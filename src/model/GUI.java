package model;

import sahiplendirme.Quiz;
import sahiplendirme.ResultEvaluator;
import staff.Veterinarian;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {

    // Mevcut veriler
    static Owner owner = new Owner("Yağmur", "Rümişoğlu", "111-2222-3333", "feyza@mail.com",
            new Address("Atatürk Cad.", "İstanbul", "34000"));

    static Veterinarian[] vets = {
        new Veterinarian("Dr. Ali Yılmaz",  "ali@mail.com",    "555-111", "Cerrahi",         new String[]{"Pazartesi", "Çarşamba", "Cuma"}),
        new Veterinarian("Dr. Ayşe Kaya",   "ayse@mail.com",   "555-222", "Dahiliye",         new String[]{"Salı", "Perşembe"}),
        new Veterinarian("Dr. Mehmet Öz",   "mehmet@mail.com", "555-333", "Göz Hastalıkları", new String[]{"Pazartesi", "Salı", "Cuma"})
    };

    static Animal[] hayvanlar = new Animal[100];
    static int hayvanSayisi = 0;

    static JFrame anaPencere;

    public static void main(String[] args) {
        anaPencereAc();
    }

    // ─── ANA MENÜ ────────────────────────────────────────────────────────────
    static void anaPencereAc() {
        anaPencere = new JFrame("PetClinic Yönetim Sistemi");
        anaPencere.setSize(420, 430);
        anaPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anaPencere.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 50, 30, 50));

        JLabel baslik = new JLabel("PetClinic Yönetim Sistemi");
        baslik.setFont(new Font("Arial", Font.BOLD, 18));
        baslik.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel altBaslik = new JLabel("Hoşgeldiniz: " + owner.getFullName());
        altBaslik.setFont(new Font("Arial", Font.PLAIN, 12));
        altBaslik.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton quizBtn        = butonOlustur("🐾  Hangi Hayvan Sana Uygun?");
        JButton hayvanKayitBtn = butonOlustur("📝  Hayvan Kaydı");
        JButton randevuBtn     = butonOlustur("📅  Randevu Oluştur");
        JButton tibbikayitBtn  = butonOlustur("💉  Tıbbi Kayıt ve Aşı");
        JButton kayitliBtn     = butonOlustur("📋  Kayıtlı Hayvanları Göster");

        quizBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { quizPenceresiAc(); }
        });
        hayvanKayitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { hayvanKayitPenceresiAc(); }
        });
        randevuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { randevuPenceresiAc(); }
        });
        tibbikayitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { tibbikayitPenceresiAc(); }
        });
        kayitliBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { kayitliHayvanlarPenceresiAc(); }
        });

        panel.add(baslik);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(altBaslik);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(quizBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(hayvanKayitBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(randevuBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tibbikayitBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(kayitliBtn);

        anaPencere.add(panel);
        anaPencere.setVisible(true);
    }

    // ─── QUIZ PENCERESİ ──────────────────────────────────────────────────────
    static void quizPenceresiAc() {

        String[] sorular = {
            "Günlük ne kadar aktif birisin?",
            "Evde ne kadar zaman geçiriyorsun?",
            "Hayvanınla ne tür bir bağ kurmak istersin?",
            "Yaşadığın yer nasıl?",
            "Hayvana ne kadar zaman ve para ayırabilirsin?",
            "Ses ve gürültüyü nasıl karşılarsın?"
        };

        String[][] secenekler = {
            {"Çok aktifim, hareketi seviyorum", "Orta seviye, bazen dışarı çıkarım", "Evde oturmayı tercih ederim"},
            {"Çoğunlukla evdeyim", "Yarı yarıya", "Çok az zaman geçiriyorum"},
            {"Sarılmak, oynamak, yakın temas", "Birlikte vakit geçirmek ama bağımsız olsun", "İzlemek ve bakımını yapmak yeterli"},
            {"Büyük ev veya bahçeli", "Normal büyüklükte daire", "Küçük daire"},
            {"Çok fazla, sorun değil", "Orta düzeyde", "Az, düşük bakım isterim"},
            {"Sorun değil, canlı bir ev severim", "Biraz ses tamam ama aşırı olmasın", "Sessiz bir ortam tercih ederim"}
        };

        // Her cevabın puanları [köpek, kedi, balık, kuş]
        int[][][] puanlar = {
            {{3,0,0,0}, {1,2,0,0}, {0,2,2,1}},
            {{0,2,2,2}, {1,1,0,0}, {0,0,3,1}},
            {{3,0,0,0}, {0,3,0,0}, {0,0,3,2}},
            {{3,0,0,0}, {1,2,0,1}, {0,1,3,2}},
            {{3,0,0,0}, {0,3,0,1}, {0,0,3,0}},
            {{2,0,0,2}, {0,2,0,1}, {0,1,3,0}}
        };

        int[] toplamPuan  = {0, 0, 0, 0};
        int[] soruIndeksi = {0};

        JFrame pencere = new JFrame("Hangi Hayvan Sana Uygun?");
        pencere.setSize(500, 380);
        pencere.setLocationRelativeTo(anaPencere);

        JPanel anaPanel = new JPanel();
        anaPanel.setLayout(new BorderLayout(10, 10));
        anaPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel ustPanel = new JPanel();
        ustPanel.setLayout(new BoxLayout(ustPanel, BoxLayout.Y_AXIS));

        JLabel numaraLabel = new JLabel("Soru 1 / " + sorular.length);
        numaraLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        numaraLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel soruLabel = new JLabel("<html><div style='text-align:center;width:400px'>" + sorular[0] + "</div></html>");
        soruLabel.setFont(new Font("Arial", Font.BOLD, 15));
        soruLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ustPanel.add(numaraLabel);
        ustPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ustPanel.add(soruLabel);

        JPanel secenekPanel = new JPanel();
        secenekPanel.setLayout(new BoxLayout(secenekPanel, BoxLayout.Y_AXIS));

        ActionListener[] listener = new ActionListener[1];

        listener[0] = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int secilenCevap = Integer.parseInt(e.getActionCommand());

                // Puanları topla
                for (int j = 0; j < 4; j++) {
                    toplamPuan[j] += puanlar[soruIndeksi[0]][secilenCevap][j];
                }

                soruIndeksi[0]++;

                if (soruIndeksi[0] < sorular.length) {
                    // Sonraki soruya geç
                    numaraLabel.setText("Soru " + (soruIndeksi[0] + 1) + " / " + sorular.length);
                    soruLabel.setText("<html><div style='text-align:center;width:400px'>" + sorular[soruIndeksi[0]] + "</div></html>");

                    secenekPanel.removeAll();
                    for (int k = 0; k < secenekler[soruIndeksi[0]].length; k++) {
                        JButton btn = secenekBtnOlustur(secenekler[soruIndeksi[0]][k], k, listener[0]);
                        secenekPanel.add(Box.createRigidArea(new Dimension(0, 8)));
                        secenekPanel.add(btn);
                    }
                    secenekPanel.revalidate();
                    secenekPanel.repaint();

                } else {
                    quizSonucGoster(toplamPuan, pencere);
                }
            }
        };

        // İlk sorunun seçeneklerini ekle
        for (int k = 0; k < secenekler[0].length; k++) {
            JButton btn = secenekBtnOlustur(secenekler[0][k], k, listener[0]);
            secenekPanel.add(Box.createRigidArea(new Dimension(0, 8)));
            secenekPanel.add(btn);
        }

        anaPanel.add(ustPanel, BorderLayout.NORTH);
        anaPanel.add(secenekPanel, BorderLayout.CENTER);

        pencere.add(anaPanel);
        pencere.setVisible(true);
    }

    static JButton secenekBtnOlustur(String yazi, int indeks, ActionListener listener) {
        JButton btn = new JButton(yazi);
        btn.setActionCommand(String.valueOf(indeks));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(420, 40));
        btn.setFont(new Font("Arial", Font.PLAIN, 13));
        btn.setBackground(new Color(240, 240, 240));
        btn.setFocusPainted(false);
        btn.addActionListener(listener);
        return btn;
    }

    static void quizSonucGoster(int[] toplamPuan, JFrame pencere) {
        String[] hayvanIsimleri = {"Köpek", "Kedi", "Balık", "Kuş"};
        String[] aciklamalar = {
            "Aktif, sosyal ve sadık bir yapın var.\nÖneri: Golden Retriever veya Beagle",
            "Bağımsız ama şefkatli bir yapıyı tercih ediyorsun.\nÖneri: British Shorthair veya Van Kedisi",
            "Huzurlu ve sakin bir yaşam tarzın var.\nÖneri: Japon Balığı veya Betta",
            "Neşeli sesleri ve canlılığı seviyorsun.\nÖneri: Muhabbet Kuşu veya Kanarya"
        };

        int enYuksekIndeks = 0;
        for (int i = 1; i < toplamPuan.length; i++) {
            if (toplamPuan[i] > toplamPuan[enYuksekIndeks]) {
                enYuksekIndeks = i;
            }
        }

        JOptionPane.showMessageDialog(pencere,
                "Sana en uygun hayvan:\n\n"
                + hayvanIsimleri[enYuksekIndeks].toUpperCase() + "\n\n"
                + aciklamalar[enYuksekIndeks],
                "Quiz Sonucu",
                JOptionPane.INFORMATION_MESSAGE);

        pencere.dispose();
    }

    // ─── HAYVAN KAYIT PENCERESİ ──────────────────────────────────────────────
    static void hayvanKayitPenceresiAc() {
        JFrame pencere = new JFrame("Hayvan Kaydı");
        pencere.setSize(400, 380);
        pencere.setLocationRelativeTo(anaPencere);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel turLabel = new JLabel("Hayvan Türü:");
        String[] turler = {"Köpek", "Kedi", "Kuş", "Balık", "At"};
        JComboBox<String> turSecici = new JComboBox<>(turler);

        JLabel adiLabel     = new JLabel("Adı:");
        JTextField adiField = new JTextField();

        JLabel cinsiLabel     = new JLabel("Cinsi:");
        JTextField cinsiField = new JTextField();

        JLabel yasLabel     = new JLabel("Yaş:");
        JTextField yasField = new JTextField();

        JLabel kiloLabel     = new JLabel("Kilo (kg):");
        JTextField kiloField = new JTextField();

        JLabel boyLabel     = new JLabel("Boy (cm):");
        JTextField boyField = new JTextField();

        JButton kaydetBtn = new JButton("Kaydet");
        kaydetBtn.setBackground(new Color(70, 130, 180));
        kaydetBtn.setForeground(Color.WHITE);
        kaydetBtn.setFocusPainted(false);

        kaydetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String ad    = adiField.getText();
                    String cinsi = cinsiField.getText();
                    int yas      = Integer.parseInt(yasField.getText());
                    double kilo  = Double.parseDouble(kiloField.getText());
                    double boy   = Double.parseDouble(boyField.getText());
                    int tur      = turSecici.getSelectedIndex() + 1;

                    Animal hayvan = null;

                    if (tur == 1) {
                        int egitim = JOptionPane.showConfirmDialog(pencere, "Eğitimi var mı?", "Köpek", JOptionPane.YES_NO_OPTION);
                        hayvan = new Dog(ad, cinsi, yas, kilo, boy, owner, egitim == JOptionPane.YES_OPTION);

                    } else if (tur == 2) {
                        int yasam = JOptionPane.showConfirmDialog(pencere, "Ev kedisi mi?", "Kedi", JOptionPane.YES_NO_OPTION);
                        int kisir = JOptionPane.showConfirmDialog(pencere, "Kısırlaştırıldı mı?", "Kedi", JOptionPane.YES_NO_OPTION);
                        hayvan = new Cat(ad, cinsi, yas, kilo, boy, owner, yasam == JOptionPane.YES_OPTION, kisir == JOptionPane.YES_OPTION);

                    } else if (tur == 3) {
                        int ucabilir   = JOptionPane.showConfirmDialog(pencere, "Uçabiliyor mu?", "Kuş", JOptionPane.YES_NO_OPTION);
                        String gaga    = JOptionPane.showInputDialog(pencere, "Gaga Yapısı:");
                        String tuyRenk = JOptionPane.showInputDialog(pencere, "Tüy Rengi:");
                        hayvan = new Bird(ad, cinsi, yas, kilo, boy, owner, ucabilir == JOptionPane.YES_OPTION, gaga, tuyRenk);

                    } else if (tur == 4) {
                        String suTipi = JOptionPane.showInputDialog(pencere, "Su Tipi:");
                        String renk   = JOptionPane.showInputDialog(pencere, "Rengi:");
                        hayvan = new Fish(ad, cinsi, yas, kilo, boy, owner, suTipi, renk);

                    } else {
                        int yaris = JOptionPane.showConfirmDialog(pencere, "Yarış atı mı?", "At", JOptionPane.YES_NO_OPTION);
                        hayvan = new Horse(ad, cinsi, yas, kilo, boy, owner, yaris == JOptionPane.YES_OPTION);
                    }

                    hayvan.register();
                    hayvanlar[hayvanSayisi] = hayvan;
                    hayvanSayisi++;

                    JOptionPane.showMessageDialog(pencere, ad + " başarıyla kaydedildi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    pencere.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pencere, "Yaş, kilo ve boy sayı olmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(turLabel);     panel.add(turSecici);
        panel.add(adiLabel);     panel.add(adiField);
        panel.add(cinsiLabel);   panel.add(cinsiField);
        panel.add(yasLabel);     panel.add(yasField);
        panel.add(kiloLabel);    panel.add(kiloField);
        panel.add(boyLabel);     panel.add(boyField);
        panel.add(new JLabel()); panel.add(kaydetBtn);

        pencere.add(panel);
        pencere.setVisible(true);
    }

    // ─── RANDEVU PENCERESİ ───────────────────────────────────────────────────
    static void randevuPenceresiAc() {
        if (hayvanSayisi == 0) {
            JOptionPane.showMessageDialog(anaPencere, "Önce hayvan kaydı yapmalısınız!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFrame pencere = new JFrame("Randevu Oluştur");
        pencere.setSize(400, 350);
        pencere.setLocationRelativeTo(anaPencere);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel hayvanLabel = new JLabel("Hayvan:");
        String[] hayvanIsimleri = new String[hayvanSayisi];
        for (int i = 0; i < hayvanSayisi; i++) {
            hayvanIsimleri[i] = hayvanlar[i].getName() + " (" + hayvanlar[i].getType() + ")";
        }
        JComboBox<String> hayvanSecici = new JComboBox<>(hayvanIsimleri);

        JLabel vetLabel = new JLabel("Veteriner:");
        String[] vetIsimleri = new String[vets.length];
        for (int i = 0; i < vets.length; i++) {
            vetIsimleri[i] = vets[i].getName() + " - " + vets[i].getSpecialization();
        }
        JComboBox<String> vetSecici = new JComboBox<>(vetIsimleri);

        JLabel tarihLabel     = new JLabel("Tarih (10.05.2026):");
        JTextField tarihField = new JTextField();

        JLabel saatLabel     = new JLabel("Saat (14:30):");
        JTextField saatField = new JTextField();

        JLabel aciklamaLabel     = new JLabel("Açıklama:");
        JTextField aciklamaField = new JTextField();

        JButton olusturBtn = new JButton("Randevu Oluştur");
        olusturBtn.setBackground(new Color(70, 130, 180));
        olusturBtn.setForeground(Color.WHITE);
        olusturBtn.setFocusPainted(false);

        olusturBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Animal secilenHayvan = hayvanlar[hayvanSecici.getSelectedIndex()];
                String secilenVet    = vets[vetSecici.getSelectedIndex()].getName();
                Appointment randevu  = new Appointment(tarihField.getText(), saatField.getText(), secilenHayvan, secilenVet, aciklamaField.getText());
                JOptionPane.showMessageDialog(pencere, "Randevunuz oluşturuldu!\n\n" + randevu, "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                pencere.dispose();
            }
        });

        panel.add(hayvanLabel);   panel.add(hayvanSecici);
        panel.add(vetLabel);      panel.add(vetSecici);
        panel.add(tarihLabel);    panel.add(tarihField);
        panel.add(saatLabel);     panel.add(saatField);
        panel.add(aciklamaLabel); panel.add(aciklamaField);
        panel.add(new JLabel());  panel.add(olusturBtn);

        pencere.add(panel);
        pencere.setVisible(true);
    }

    // ─── TIBBİ KAYIT PENCERESİ ───────────────────────────────────────────────
    static void tibbikayitPenceresiAc() {
        if (hayvanSayisi == 0) {
            JOptionPane.showMessageDialog(anaPencere, "Önce hayvan kaydı yapmalısınız!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFrame pencere = new JFrame("Tıbbi Kayıt ve Aşı");
        pencere.setSize(400, 400);
        pencere.setLocationRelativeTo(anaPencere);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel hayvanLabel = new JLabel("Hayvan:");
        String[] hayvanIsimleri = new String[hayvanSayisi];
        for (int i = 0; i < hayvanSayisi; i++) {
            hayvanIsimleri[i] = hayvanlar[i].getName() + " (" + hayvanlar[i].getType() + ")";
        }
        JComboBox<String> hayvanSecici = new JComboBox<>(hayvanIsimleri);

        JLabel tarihLabel     = new JLabel("Tarih:");
        JTextField tarihField = new JTextField();

        JLabel taniLabel     = new JLabel("Hastalık Tanısı:");
        JTextField taniField = new JTextField();

        JLabel tedaviLabel     = new JLabel("Tedavi:");
        JTextField tedaviField = new JTextField();

        JLabel asiLabel     = new JLabel("Aşı Adı:");
        JTextField asiField = new JTextField();

        JLabel sonrakiLabel     = new JLabel("Sonraki Aşı Tarihi:");
        JTextField sonrakiField = new JTextField();

        JButton kaydetBtn = new JButton("Kaydet");
        kaydetBtn.setBackground(new Color(70, 130, 180));
        kaydetBtn.setForeground(Color.WHITE);
        kaydetBtn.setFocusPainted(false);

        kaydetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Animal secilenHayvan = hayvanlar[hayvanSecici.getSelectedIndex()];
                MedicalRecord kayit  = new MedicalRecord(tarihField.getText(), taniField.getText(), tedaviField.getText(), secilenHayvan);
                Vaccine asi          = new Vaccine(asiField.getText(), tarihField.getText(), sonrakiField.getText(), secilenHayvan);
                JOptionPane.showMessageDialog(pencere,
                        "Kayıtlar oluşturuldu!\n\nTıbbi Kayıt: " + kayit + "\n\nAşı Kaydı: " + asi,
                        "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                pencere.dispose();
            }
        });

        panel.add(hayvanLabel);  panel.add(hayvanSecici);
        panel.add(tarihLabel);   panel.add(tarihField);
        panel.add(taniLabel);    panel.add(taniField);
        panel.add(tedaviLabel);  panel.add(tedaviField);
        panel.add(asiLabel);     panel.add(asiField);
        panel.add(sonrakiLabel); panel.add(sonrakiField);
        panel.add(new JLabel()); panel.add(kaydetBtn);

        pencere.add(panel);
        pencere.setVisible(true);
    }

    // ─── KAYITLI HAYVANLAR PENCERESİ ─────────────────────────────────────────
    static void kayitliHayvanlarPenceresiAc() {
        JFrame pencere = new JFrame("Kayıtlı Hayvanlar");
        pencere.setSize(500, 400);
        pencere.setLocationRelativeTo(anaPencere);

        JTextArea metin = new JTextArea();
        metin.setEditable(false);
        metin.setFont(new Font("Monospaced", Font.PLAIN, 13));
        metin.setBorder(new EmptyBorder(10, 10, 10, 10));

        if (hayvanSayisi == 0) {
            metin.setText("Henüz kayıtlı hayvan bulunmuyor.");
        } else {
            String icerik = "";
            for (int i = 0; i < hayvanSayisi; i++) {
                icerik = icerik + (i + 1) + ". Hayvan\n";
                icerik = icerik + "-----------------------------\n";
                icerik = icerik + hayvanlar[i].toString() + "\n\n";
            }
            metin.setText(icerik);
        }

        pencere.add(new JScrollPane(metin));
        pencere.setVisible(true);
    }

    // ─── YARDIMCI: Buton oluşturucu ──────────────────────────────────────────
    static JButton butonOlustur(String yazi) {
        JButton btn = new JButton(yazi);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(280, 42));
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }
}

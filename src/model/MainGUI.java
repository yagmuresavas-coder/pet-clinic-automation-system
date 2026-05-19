// Java'da GUI için kullandığımız kütüphane -> Swing
// Swing, Java'nın yerleşik arayüz kütüphanesidir.
//JFrame (pencere), JButton (buton), JLabel (yazı), JTextField (metin kutusu)
package model;
import staff.Veterinarian;            
import javax.swing.*;                  // Tüm Swing bileşenleri (JFrame, JButton, JLabel, vb.)
import javax.swing.border.EmptyBorder; // Kenarlıklara boşluk (padding) eklemek için
import java.awt.*;                     // Renk (Color), Font, Dimension gibi temel görsel araçlar
import java.awt.event.ActionEvent;     // Buton tıklaması gibi olayları temsil eden sınıf
import java.awt.event.ActionListener;  // Buton tıklandığında ne yapılacağını belirleyen arayüz

public class MainGUI { // Sahibi temsil eden nesne: Ad, soyad, telefon, e-posta ve adres bilgileriyle oluşturuluyor.
    static Owner owner = new Owner(
        "Yağmur",                             
        "Rümişoğlu",                           
        "111-2222-3333",                      
        "feyza@mail.com",                     
        new Address("Atatürk Cad.", "İstanbul", "34000") );
    
    // Veteriner dizisi: 3 farklı veteriner ve bilgileri oluşturuluyor.
    static Veterinarian[] vets = {
        new Veterinarian("Dr. Ali Yılmaz",  "ali@mail.com",    "555-111", "Veteriner Cerrahi",          new String[]{"Pazartesi", "Çarşamba", "Cuma"}),
        new Veterinarian("Dr. Ayşe Kaya",   "ayse@mail.com",   "555-222", "Veteriner İç Hastalıkları",          new String[]{"Salı", "Perşembe"}),
        new Veterinarian("Dr. Mehmet Öz",   "mehmet@mail.com", "555-333", "Veteriner Onkoloji",  new String[]{"Pazartesi", "Salı", "Cuma"})};
    
    // Kayıtlı hayvanların tutulacağı dizi. Maksimum 100 hayvan tutabilir.
    // Başlangıçta tüm elemanlar null (boş) olarak gelir.
    static Animal[] hayvanlar = new Animal[100];
    
    // Şu anda kaç hayvan kaydedildiğini tutan sayaç.
    // Aynı zamanda bir sonraki hayvanın hangi indekse yazılacağını gösterir.
    static int hayvanSayisi = 0;
    
    // Ana pencereyi (JFrame) temsil eden değişken.
    // Bu değişkeni diğer metodlardan da erişilebilir kılmak için statictir.
    static JFrame anaPencere;
    
    public static void main(String[] args) {
        anaPencereAc(); /*Ana menü penceresini aç ve programı başlat*/}
    
    // ANA MENÜ PENCERESİ
    // Bu metod, programın ilk açıldığında gösterilen ana menüyü oluşturur.
    static void anaPencereAc(){
    	
        //Pencere (JFrame) Oluşturma
        // JFrame: Swing'de bir masaüstü penceresi.
        // Parametre olarak verilen String pencere başlığı olur.
        anaPencere = new JFrame("PetClinic Yönetim Sistemi");
        anaPencere.setSize(420, 430);                          // Genişlik: 420px, Yükseklik: 430px
        anaPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencere kapatılınca program sonlansın
        anaPencere.setLocationRelativeTo(null);                // Pencereyi ekranın ortasına yerleştir
        
        //Panel (Düzen Konteyneri) Oluşturma
        // JPanel: İçine bileşen ekleyebildiğimiz kutu şeklindeki bölge.
        JPanel panel = new JPanel();
        
        // BoxLayout: Bileşenleri sırayla (dikey veya yatay) dizer.
        // BoxLayout.Y_AXIS → Bileşenler üstten alta doğru sıralanır (dikey).
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // EmptyBorder: Panelin kenarlarına boşluk (padding) ekler.
        // Sıra: üst=30, sol=50, alt=30, sağ=50
        panel.setBorder(new EmptyBorder(30, 50, 30, 50));
        
        //Başlık Etiketi
        // JLabel: Ekranda sabit metin göstermek için kullanılır.
        JLabel baslik = new JLabel("PetClinic Yönetim Sistemi");
        baslik.setFont(new Font("Arial", Font.BOLD, 18)); // Yazı tipi: Arial, kalın, 18 punto
        baslik.setAlignmentX(Component.CENTER_ALIGNMENT); // Yatayda ortala
        
        // owner.getFullName() → Owner nesnesindeki tam adı döndürür.
        JLabel altBaslik = new JLabel("Hoşgeldiniz: " + owner.getFullName());
        altBaslik.setFont(new Font("Arial", Font.PLAIN, 12)); // Normal kalınlık, 12 punto
        altBaslik.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Menü Butonları
        // butonOlustur Aşağıda tanımlanan yardımcı metod.
        // Tekrar eden buton ayarlarını tek yerden yapıyoruz.
        JButton quizBtn        = butonOlustur("Hangi Hayvan Sana Uygun?");
        JButton hayvanKayitBtn = butonOlustur("Hayvan Kaydı");
        JButton randevuBtn     = butonOlustur("Randevu Oluştur");
        JButton tibbikayitBtn  = butonOlustur("Tıbbi Kayıt ve Aşı");
        JButton kayitliBtn     = butonOlustur("Kayıtlı Hayvanları Göster");
        
        // Butonlara Tıklama Olayı (ActionListener) Ekleme 
        // ActionListener: Bir butona tıklandığında ne olacağını tanımlar.
        // new ActionListener()→ "Anonim sınıf" denir. Tek kullanımlık sınıf tanımıdır.
        // actionPerformed: Tıklama gerçekleşince otomatik çağrılan metod.
        quizBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quizPenceresiAc(); // Quiz penceresini aç
            }
        });
        hayvanKayitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hayvanKayitPenceresiAc(); // Hayvan kayıt penceresini aç
            }
        });
        randevuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randevuPenceresiAc(); // Randevu penceresini aç
            }
        });
        tibbikayitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tibbikayitPenceresiAc(); // Tıbbi kayıt penceresini aç
            }
        });
        kayitliBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kayitliHayvanlarPenceresiAc(); // Kayıtlı hayvanlar penceresini aç
            }
        });
        // Bileşenleri Panele Ekleme
        // Box.createRigidArea() Bileşenler arasına sabit boşluk koyar.
        // new Dimension(genişlik, yükseklik) Piksel cinsinden boyut.
        panel.add(baslik);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));   // 5px dikey boşluk
        panel.add(altBaslik);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));  // 25px dikey boşluk
        panel.add(quizBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(hayvanKayitBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(randevuBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tibbikayitBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(kayitliBtn);
        
        // Paneli pencereye ekle ve pencereyi görünür yap
        anaPencere.add(panel);
        anaPencere.setVisible(true); // false olursa pencere açılmaz!
    }
    // QUİZ PENCERESİ "Hangi Hayvan Sana Uygun?" oyunu
    // Kullanıcıya 6 soru sorar, cevaplara göre puan hesaplar,
    // en yüksek puan alan hayvan türünü önerir.
    static void quizPenceresiAc() {
        // Sorular Dizisi 
        // String[] → Metin (String) tipinde dizi.
        // Her indeks bir soruyu temsil eder. Örn: sorular[0] = "Günlük ne kadar aktif..."
        String[] sorular = {
            "Günlük ne kadar aktif birisin?",
            "Evde ne kadar zaman geçiriyorsun?",
            "Hayvanınla ne tür bir bağ kurmak istersin?",
            "Yaşadığın yer nasıl?",
            "Hayvana ne kadar zaman ve para ayırabilirsin?",
            "Ses ve gürültüyü nasıl karşılarsın?"
        };
        // Seçenekler Dizisi
        // String[][] → 2 boyutlu dizi (dizi içinde dizi).
        // secenekler[i] → i. sorunun seçenekleri.
        // secenekler[i][j] → i. sorunun j. seçeneği.
        String[][] secenekler = {
            {"Çok aktifim, hareketi seviyorum", "Orta seviye, bazen dışarı çıkarım", "Evde oturmayı tercih ederim"},
            {"Çoğunlukla evdeyim", "Yarı yarıya", "Çok az zaman geçiriyorum"},
            {"Sarılmak, oynamak, yakın temas", "Birlikte vakit geçirmek ama bağımsız olsun", "İzlemek ve bakımını yapmak yeterli"},
            {"Büyük ev veya bahçeli", "Normal büyüklükte daire", "Küçük daire"},
            {"Çok fazla, sorun değil", "Orta düzeyde", "Az, düşük bakım isterim"},
            {"Sorun değil, canlı bir ev severim", "Biraz ses tamam ama aşırı olmasın", "Sessiz bir ortam tercih ederim"}
        };
        // Puan Tablosu
        // int[][][] 3 boyutlu dizi (en karmaşık yapı burada).
        // Boyutlar: [soru indeksi][seçenek indeksi][hayvan indeksi]
        // Hayvan indeksleri: 0=Köpek, 1=Kedi, 2=Balık, 3=Kuş
        int[][][] puanlar = {
            {{3,0,0,0}, {1,2,0,0}, {0,2,2,1}},  // Soru 1: Aktivite
            {{0,2,2,2}, {1,1,0,0}, {0,0,3,1}},  // Soru 2: Evde geçirilen zaman
            {{3,0,0,0}, {0,3,0,0}, {0,0,3,2}},  // Soru 3: Bağ türü
            {{3,0,0,0}, {1,2,0,1}, {0,1,3,2}},  // Soru 4: Yaşam yeri
            {{3,0,0,0}, {0,3,0,1}, {0,0,3,0}},  // Soru 5: Zaman/para
            {{2,0,0,2}, {0,2,0,1}, {0,1,3,0}}   // Soru 6: Ses toleransı
        };
        // Toplam Puanlar
        // Her hayvan için biriken puan burada tutulur. Başlangıçta hepsi 0.
        // indeks: 0=Köpek, 1=Kedi, 2=Balık, 3=Kuş
        int[] toplamPuan = {0, 0, 0, 0};
        // ── Soru İndeksi ──
        // int[] şeklinde dizi kullanılmasının sebebi:
        // ActionListener içinde değişkeni değiştirebilmek için "effectively final" olmalı.
        // Dizi referansı değişmediğinden bu kısıtlamayı aşarız.
        int[] soruIndeksi = {0};
        // ── Quiz Penceresi ──
        JFrame pencere = new JFrame("Hangi Hayvan Sana Uygun?");
        pencere.setSize(500, 380);
        pencere.setLocationRelativeTo(anaPencere); // Ana pencerenin yanında aç
        // ── Ana Panel (BorderLayout) ──
        // BorderLayout: Ekranı 5 bölgeye ayırır: NORTH, SOUTH, EAST, WEST, CENTER.
        // Burada NORTH=başlık, CENTER=seçenekler bölgesi olarak kullanılıyor.
        JPanel anaPanel = new JPanel();
        anaPanel.setLayout(new BorderLayout(10, 10)); // 10px yatay, 10px dikey boşluk
        anaPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        // ── Üst Panel (Soru numarası + soru metni) ──
        JPanel ustPanel = new JPanel();
        ustPanel.setLayout(new BoxLayout(ustPanel, BoxLayout.Y_AXIS)); // Dikey sıralama
        // "Soru 1 / 6" gibi bir ilerleme göstergesi
        JLabel numaraLabel = new JLabel("Soru 1 / " + sorular.length);
        numaraLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        numaraLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Soru metni. HTML kullanarak metni ortalar ve genişliğini sınırlarız.
        JLabel soruLabel = new JLabel(
            "<html><div style='text-align:center;width:400px'>" + sorular[0] + "</div></html>"
        );
        soruLabel.setFont(new Font("Arial", Font.BOLD, 15));
        soruLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ustPanel.add(numaraLabel);
        ustPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        ustPanel.add(soruLabel);
        //Seçenek Butonları Paneli
        JPanel secenekPanel = new JPanel();
        secenekPanel.setLayout(new BoxLayout(secenekPanel, BoxLayout.Y_AXIS));
        //ActionListener (Tıklama Olayı)
        // Dizi olarak tanımlanmasının sebebi: lambda içinden referansa erişebilmek.
        ActionListener[] listener = new ActionListener[1];
        listener[0] = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // e.getActionCommand() Tıklanan butonun "actionCommand" değerini verir.
                // Biz bunu seçenek indeksi olarak kullanıyoruz (0, 1 veya 2).
                int secilenCevap = Integer.parseInt(e.getActionCommand());
                // Seçilen cevaba göre her hayvanın puanını güncelle
                // for döngüsü: j sırayla 0, 1, 2, 3 değerlerini alır (4 hayvan).
                for (int j = 0; j < 4; j++) {
                    toplamPuan[j] += puanlar[soruIndeksi[0]][secilenCevap][j];
                }
                soruIndeksi[0]++; // Bir sonraki soruya geçer.

                //Sonraki Soru Var mı?
                if (soruIndeksi[0] < sorular.length) {
                    // Daha soru var: etiketleri ve butonları güncelle
                    // Soru numarasını güncelle
                    numaraLabel.setText("Soru " + (soruIndeksi[0] + 1) + " / " + sorular.length);
                    // Yeni soru metnini ayarla
                    soruLabel.setText(
                        "<html><div style='text-align:center;width:400px'>"
                        + sorular[soruIndeksi[0]]
                        + "</div></html>"
                    );
                    // Mevcut seçenek butonlarını temizle ve yenilerini ekle
                    secenekPanel.removeAll(); // Eski butonları sil
                    for (int k = 0; k < secenekler[soruIndeksi[0]].length; k++) {
                        JButton btn = secenekBtnOlustur(secenekler[soruIndeksi[0]][k], k, listener[0]);
                        secenekPanel.add(Box.createRigidArea(new Dimension(0, 8)));
                        secenekPanel.add(btn);
                    }
                    // revalidate: Düzeni yeniden hesapla (bileşen eklendikten sonra şart)
                    // repaint: Ekranı yeniden çiz
                    secenekPanel.revalidate();
                    secenekPanel.repaint();
                } else {
                    // Tüm sorular bitti: Sonucu hesapla ve göster
                    quizSonucGoster(toplamPuan, pencere);
                } } };
        //İlk Sorunun Seçeneklerini Panele Ekle
        for (int k = 0; k < secenekler[0].length; k++) {
            JButton btn = secenekBtnOlustur(secenekler[0][k], k, listener[0]);
            secenekPanel.add(Box.createRigidArea(new Dimension(0, 8)));
            secenekPanel.add(btn);
        }
        // Panelleri düzenle ve pencereyi göster
        anaPanel.add(ustPanel,    BorderLayout.NORTH);  // Üste soru
        anaPanel.add(secenekPanel, BorderLayout.CENTER); // Ortaya seçenekler
        pencere.add(anaPanel);
        pencere.setVisible(true); }
    //Quiz için Seçenek Butonu Oluşturucu 
    // Parametreler:
    //   yazi: Buton üzerindeki metin
    //   indeks: Bu seçeneğin sırası (0, 1 veya 2) — puan hesabı için kullanılır
    //   listener → Tıklandığında ne olacağı
    static JButton secenekBtnOlustur(String yazi, int indeks, ActionListener listener) {
        JButton btn = new JButton(yazi);
        // ActionCommand: Butona özel bir "kimlik" metni verir.
        // actionPerformed içinde e.getActionCommand() ile okuruz.
        btn.setActionCommand(String.valueOf(indeks)); // indeks sayısını String'e çevir
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(420, 40)); // Maksimum genişlik 420px, yükseklik 40px
        btn.setFont(new Font("Arial", Font.PLAIN, 13));
        btn.setBackground(new Color(240, 240, 240)); // Açık gri arka plan
        btn.setFocusPainted(false); // Tıklandığında mavi çerçeve gösterme
        btn.addActionListener(listener);
        return btn;}
    // ── Quiz Sonucu Gösterici ────────────────────────────────────────────────
    // En yüksek puanlı hayvanı bulur ve sonuç iletişim kutusunda gösterir.
    static void quizSonucGoster(int[] toplamPuan, JFrame pencere) {
        // Hayvan isimleri — indeks sırası toplamPuan dizisiyle eşleşmeli
        String[] hayvanIsimleri = {"Köpek", "Kedi", "Balık", "Kuş"};
        // Her hayvan için açıklama metni
        String[] aciklamalar = {
            "Aktif, sosyal ve sadık bir yapın var.\nÖneri: Golden Retriever veya Beagle",
            "Bağımsız ama şefkatli bir yapıyı tercih ediyorsun.\nÖneri: British Shorthair veya Van Kedisi",
            "Huzurlu ve sakin bir yaşam tarzın var.\nÖneri: Japon Balığı veya Betta",
            "Neşeli sesleri ve canlılığı seviyorsun.\nÖneri: Muhabbet Kuşu veya Kanarya"
        };
        // En yüksek puanlı hayvanın indeksini bul
        int enYuksekIndeks = 0; // Başlangıçta 0. hayvan (Köpek) en yüksek varsay
        for (int i = 1; i < toplamPuan.length; i++) {
            // Eğer i. hayvanın puanı şimdiye kadarki en yüksekten büyükse:
            if (toplamPuan[i] > toplamPuan[enYuksekIndeks]) {
                enYuksekIndeks = i; // Yeni en yüksek indeks
            }}
        // JOptionPane.showMessageDialog → Hazır mesaj kutusu (bildirim penceresi) gösterir.
        // Parametreler: (ebeveyn pencere, mesaj, başlık, ikon türü)
        JOptionPane.showMessageDialog(pencere,
            "Sana en uygun hayvan:\n\n"
            + hayvanIsimleri[enYuksekIndeks].toUpperCase() // Büyük harfe çevir
            + "\n\n"
            + aciklamalar[enYuksekIndeks],
            "Quiz Sonucu",
            JOptionPane.INFORMATION_MESSAGE // Bilgi ikonu (mavi 'i')
        );
        pencere.dispose(); // Pencereyi kapat ve bellekten temizle
    }
    // HAYVAN KAYIT PENCERESİ
    // Kullanıcının yeni bir hayvan kaydetmesini sağlar.
    // Tür seçimine göre ek bilgiler istenir (örn: köpek için eğitim durumu).
    static void hayvanKayitPenceresiAc() {
        JFrame pencere = new JFrame("Hayvan Kaydı");
        pencere.setSize(400, 380);
        pencere.setLocationRelativeTo(anaPencere);
        // ── GridLayout: Izgara (Tablo) Düzeni ──
        // GridLayout(satırSayısı, sütunSayısı, yatayBoşluk, dikeyBoşluk)
        // 0 satır → satır sayısı otomatik artar.
        // 2 sütun → Solda etiket, sağda giriş alanı.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        // ── Form Bileşenleri ──
        JLabel turLabel = new JLabel("Hayvan Türü:");
        String[] turler = {"Köpek", "Kedi", "Kuş", "Balık", "At"};
        // JComboBox: Açılır liste bileşeni.
        JComboBox<String> turSecici = new JComboBox<>(turler);
        JLabel adiLabel     = new JLabel("Adı:");
        JTextField adiField = new JTextField(); // Tek satırlı metin giriş kutusu
        JLabel cinsiLabel     = new JLabel("Cinsi:");
        JTextField cinsiField = new JTextField();
        JLabel yasLabel     = new JLabel("Yaş:");
        JTextField yasField = new JTextField();
        JLabel kiloLabel     = new JLabel("Kilo (kg):");
        JTextField kiloField = new JTextField();
        JLabel boyLabel    = new JLabel("Boy (cm):");
        JTextField boyField = new JTextField();
        // ── Kaydet Butonu ──
        JButton kaydetBtn = new JButton("Kaydet");
        kaydetBtn.setBackground(new Color(70, 130, 180)); // Çelik mavi
        kaydetBtn.setForeground(Color.WHITE);              // Beyaz yazı
        kaydetBtn.setFocusPainted(false);
        // ── Kaydet Butonuna Tıklama Olayı ──
        kaydetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // try-catch: Hata yakalama bloğu.
                // Kullanıcı yaş/kilo/boy alanlarına harf girerse sayıya çevirme başarısız olur.
                // Bu durumda NumberFormatException fırlatılır; catch bloğu hata mesajı gösterir.
                try {
                    String ad    = adiField.getText().trim();  // getText() → kutu içeriğini al
                   if(ad.matches(".*\\d.*")) {
                	   JOptionPane.showMessageDialog(pencere,"İsim Alanına Sayı Girilemez!","GİRİŞ HATASI", JOptionPane.ERROR_MESSAGE);
                	   return;
                   }
                    String cinsi = cinsiField.getText();
                    if(ad.matches(".*\\d.*")) {
                 	   JOptionPane.showMessageDialog(pencere,"Cins Alanına Sayı Girilemez!","GİRİŞ HATASI", JOptionPane.ERROR_MESSAGE);
                 	   return;
                    }
                    int    yas   = Integer.parseInt(yasField.getText()); // String → int dönüşüm                    
                    double kilo  = Double.parseDouble(kiloField.getText()); // String → double
                    double boy   = Double.parseDouble(boyField.getText());
                    if(yas<0 || kilo<0 || boy<0){
                    	JOptionPane.showMessageDialog(pencere,"Yaş,Boy veya Kilo negatif değer ALAMAZ!","GİRİŞ HATASI", JOptionPane.ERROR_MESSAGE);
                  	   return;
                    }
                    // getSelectedIndex() → Seçili elemanın sırasını döndürür (0'dan başlar).
                    // +1 yapıyoruz çünkü tur değişkenini 1-5 arası kullanıyoruz.
                    int tur = turSecici.getSelectedIndex() + 1;
                    Animal hayvan = null; // Hangi türde hayvan oluşturulacağı henüz bilinmiyor
                    // Seçilen türe göre ilgili alt sınıftan nesne oluştur
                    if (tur == 1) { // Köpek
                        // showConfirmDialog → Evet/Hayır sorusu sorar.
                        // Döndürdüğü değer: JOptionPane.YES_OPTION veya NO_OPTION
                        int egitim = JOptionPane.showConfirmDialog(pencere, "Eğitimi var mı?", "Köpek", JOptionPane.YES_NO_OPTION);
                        // egitim == JOptionPane.YES_OPTION → true veya false döner (boolean)
                        hayvan = new Dog(ad, cinsi, yas, kilo, boy, owner, egitim == JOptionPane.YES_OPTION);
                    } else if (tur == 2) { // Kedi
                        int yasam = JOptionPane.showConfirmDialog(pencere, "Ev kedisi mi?",        "Kedi", JOptionPane.YES_NO_OPTION);
                        int kisir = JOptionPane.showConfirmDialog(pencere, "Kısırlaştırıldı mı?",  "Kedi", JOptionPane.YES_NO_OPTION);
                        hayvan = new Cat(ad, cinsi, yas, kilo, boy, owner,
                                         yasam == JOptionPane.YES_OPTION,
                                         kisir == JOptionPane.YES_OPTION);
                    } else if (tur == 3) { // Kuş
                        int    ucabilir = JOptionPane.showConfirmDialog(pencere, "Uçabiliyor mu?", "Kuş", JOptionPane.YES_NO_OPTION);
                        // showInputDialog → Kullanıcıdan metin girmesini isteyen küçük pencere
                        String gaga     = JOptionPane.showInputDialog(pencere, "Gaga Yapısı:");
                        String tuyRenk  = JOptionPane.showInputDialog(pencere, "Tüy Rengi:");
                        hayvan = new Bird(ad, cinsi, yas, kilo, boy, owner,
                                          ucabilir == JOptionPane.YES_OPTION, gaga, tuyRenk);
                    } else if (tur == 4) { // Balık
                        String suTipi = JOptionPane.showInputDialog(pencere, "Su Tipi:");
                        String renk   = JOptionPane.showInputDialog(pencere, "Rengi:");
                        hayvan = new Fish(ad, cinsi, yas, kilo, boy, owner, suTipi, renk);
                    } else { // At (tur == 5)
                        int yaris = JOptionPane.showConfirmDialog(pencere, "Yarış atı mı?", "At", JOptionPane.YES_NO_OPTION);
                        hayvan = new Horse(ad, cinsi, yas, kilo, boy, owner, yaris == JOptionPane.YES_OPTION);
                    }
                    hayvan.register(); // Hayvanı sisteme kaydet (Animal sınıfındaki metod)
                    // Hayvanı diziye ekle ve sayacı artır
                    hayvanlar[hayvanSayisi] = hayvan; // Mevcut konuma yaz
                    hayvanSayisi++;                   // Bir sonraki boş konuma geç
                    JOptionPane.showMessageDialog(pencere,
                        ad + " başarıyla kaydedildi!",
                        "Başarılı",
                        JOptionPane.INFORMATION_MESSAGE);
                    pencere.dispose(); // Kayıt başarılı → pencereyi kapat
                } catch (NumberFormatException ex) {
                    // Sayıya dönüştürme başarısız olursa bu blok çalışır
                    JOptionPane.showMessageDialog(pencere,
                        "Yaş, kilo ve boy sayı olmalıdır!",
                        "Hata",
                        JOptionPane.ERROR_MESSAGE); // Kırmızı hata ikonu
                }}});
        // ── Bileşenleri GridLayout'a Ekle ──
        // GridLayout soldan sağa, üstten alta doldurur.
        // Her satıra önce etiket (JLabel), sonra giriş alanı ekliyoruz.
        panel.add(turLabel);     panel.add(turSecici);
        panel.add(adiLabel);     panel.add(adiField);
        panel.add(cinsiLabel);   panel.add(cinsiField);
        panel.add(yasLabel);     panel.add(yasField);
        panel.add(kiloLabel);    panel.add(kiloField);
        panel.add(boyLabel);     panel.add(boyField);
        panel.add(new JLabel()); // Boş hücre (sol sütun) → butonu sağa it
        panel.add(kaydetBtn);
        pencere.add(panel);
        pencere.setVisible(true);
    }
    // RANDEVU PENCERESİ
    // Kayıtlı bir hayvan ve veteriner seçerek randevu oluşturulur.
    static void randevuPenceresiAc() {
        // ── Ön Kontrol: Kayıtlı hayvan var mı? ──
        // Hayvan yoksa randevu oluşturulamaz, uyarı ver ve geri dön.
        if (hayvanSayisi == 0) {
            JOptionPane.showMessageDialog(anaPencere,
                "Önce hayvan kaydı yapmalısınız!",
                "Uyarı",
                JOptionPane.WARNING_MESSAGE); // Sarı uyarı ikonu
            return; // Metodun geri kalanını çalıştırma, buradan çık
        }
        JFrame pencere = new JFrame("Randevu Oluştur");
        pencere.setSize(400, 350);
        pencere.setLocationRelativeTo(anaPencere);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        // ── Hayvan Seçici (Açılır Liste) ──
        JLabel hayvanLabel = new JLabel("Hayvan:");
        // Kayıtlı her hayvanın adını ve türünü içeren String dizisi oluştur
        String[] hayvanIsimleri = new String[hayvanSayisi];
        for (int i = 0; i < hayvanSayisi; i++) {
            hayvanIsimleri[i] = hayvanlar[i].getName() + " (" + hayvanlar[i].getType() + ")";
        }
        JComboBox<String> hayvanSecici = new JComboBox<>(hayvanIsimleri);
        //Veteriner Seçici 
        JLabel vetLabel = new JLabel("Veteriner:");
        // Her veterinerin adını ve uzmanlığını içeren String dizisi
        String[] vetIsimleri = new String[vets.length];
        for (int i = 0; i < vets.length; i++) {
            vetIsimleri[i] = vets[i].getName() + " - " + vets[i].getSpecialization();
        }
        JComboBox<String> vetSecici = new JComboBox<>(vetIsimleri);
        //Tarih, Saat, Açıklama Alanları
        JLabel     tarihLabel    = new JLabel("Tarih (10.05.2026):");
        JTextField tarihField    = new JTextField();
        JLabel     saatLabel     = new JLabel("Saat (14:30):");
        JTextField saatField     = new JTextField();
        JLabel     aciklamaLabel = new JLabel("Açıklama:");
        JTextField aciklamaField = new JTextField();
        // ── Randevu Oluştur Butonu ──
        JButton olusturBtn = new JButton("Randevu Oluştur");
        olusturBtn.setBackground(new Color(70, 130, 180));
        olusturBtn.setForeground(Color.WHITE);
        olusturBtn.setFocusPainted(false);
        olusturBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // getSelectedIndex() Listede seçili elemanın sırasını verir.
                // Bu sıra ile hayvanlar[] dizisinden doğru hayvanı seçiyoruz.
                Animal secilenHayvan = hayvanlar[hayvanSecici.getSelectedIndex()];
                // Veteriner adını al (sadece isim yeterli)
                String secilenVet = vets[vetSecici.getSelectedIndex()].getName();
                // Yeni bir Appointment (randevu) nesnesi oluştur
                Appointment randevu = new Appointment(
                    tarihField.getText(),
                    saatField.getText(),
                    secilenHayvan,
                    secilenVet,
                    aciklamaField.getText()
                );
                // Randevu bilgilerini göster (randevu.toString() otomatik çağrılır)
                JOptionPane.showMessageDialog(pencere,
                    "Randevunuz oluşturuldu!\n\n" + randevu,
                    "Başarılı",
                    JOptionPane.INFORMATION_MESSAGE);
                pencere.dispose();
            }});
        // Bileşenleri ekle
        panel.add(hayvanLabel);   panel.add(hayvanSecici);
        panel.add(vetLabel);      panel.add(vetSecici);
        panel.add(tarihLabel);    panel.add(tarihField);
        panel.add(saatLabel);     panel.add(saatField);
        panel.add(aciklamaLabel); panel.add(aciklamaField);
        panel.add(new JLabel());  panel.add(olusturBtn);
        pencere.add(panel);
        pencere.setVisible(true);
    }
    // TIBBİ KAYIT PENCERESİ
    // Bir hayvana tıbbi kayıt (hastalık, tedavi) ve aşı kaydı eklenir.
    static void tibbikayitPenceresiAc() {
        //  Ön Kontrol 
        if (hayvanSayisi == 0) {
            JOptionPane.showMessageDialog(anaPencere,
                "Önce hayvan kaydı yapmalısınız!",
                "Uyarı",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        JFrame pencere = new JFrame("Tıbbi Kayıt ve Aşı");
        pencere.setSize(400, 400);
        pencere.setLocationRelativeTo(anaPencere);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        //Hayvan Seçici
        JLabel hayvanLabel = new JLabel("Hayvan:");
        String[] hayvanIsimleri = new String[hayvanSayisi];
        for (int i = 0; i < hayvanSayisi; i++) {
            hayvanIsimleri[i] = hayvanlar[i].getName() + " (" + hayvanlar[i].getType() + ")";
        }
        JComboBox<String> hayvanSecici = new JComboBox<>(hayvanIsimleri);
        //Form Alanları
        JLabel     tarihLabel  = new JLabel("Tarih:");
        JTextField tarihField  = new JTextField();
        JLabel     taniLabel   = new JLabel("Hastalık Tanısı:");
        JTextField taniField   = new JTextField();
        JLabel     tedaviLabel = new JLabel("Tedavi:");
        JTextField tedaviField = new JTextField();
        JLabel     asiLabel    = new JLabel("Aşı Adı:");
        JTextField asiField    = new JTextField();
        JLabel     sonrakiLabel = new JLabel("Sonraki Aşı Tarihi:");
        JTextField sonrakiField = new JTextField();
        //Kaydet Butonu
        JButton kaydetBtn = new JButton("Kaydet");
        kaydetBtn.setBackground(new Color(70, 130, 180));
        kaydetBtn.setForeground(Color.WHITE);
        kaydetBtn.setFocusPainted(false);
        kaydetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Animal secilenHayvan = hayvanlar[hayvanSecici.getSelectedIndex()];
                // MedicalRecord: Tıbbi kayıt nesnesi
                // Parametreler: tarih, tanı, tedavi, hayvan
                MedicalRecord kayit = new MedicalRecord(
                    tarihField.getText(),
                    taniField.getText(),
                    tedaviField.getText(),
                    secilenHayvan
                );
                // Vaccine: Aşı kaydı nesnesi
                // Parametreler: aşı adı, tarih, sonraki aşı tarihi, hayvan
                Vaccine asi = new Vaccine(
                    asiField.getText(),
                    tarihField.getText(),
                    sonrakiField.getText(),
                    secilenHayvan
                );
                // Her iki kaydı da tek mesaj kutusunda göster
                JOptionPane.showMessageDialog(pencere,
                    "Kayıtlar oluşturuldu!\n\nTıbbi Kayıt: " + kayit
                    + "\n\nAşı Kaydı: " + asi,
                    "Başarılı",
                    JOptionPane.INFORMATION_MESSAGE);
                pencere.dispose();
            }});
        // Bileşenleri ekle
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
    // KAYITLI HAYVANLAR PENCERESİ
    // Sisteme kayıtlı tüm hayvanların bilgilerini listeleyen pencere.
    static void kayitliHayvanlarPenceresiAc() {
        JFrame pencere = new JFrame("Kayıtlı Hayvanlar");
        pencere.setSize(500, 400);
        pencere.setLocationRelativeTo(anaPencere);
        // JTextArea: Çok satırlı metin görüntüleyici.
        // setEditable(false): Kullanıcı düzenleyemesin (sadece okusun).
        JTextArea metin = new JTextArea();
        metin.setEditable(false);
        metin.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Sabit genişlikli font (tablo gibi görünür)
        metin.setBorder(new EmptyBorder(10, 10, 10, 10));
        if (hayvanSayisi == 0) {
            // Hiç hayvan yoksa bilgi mesajı göster
            metin.setText("Henüz kayıtlı hayvan bulunmuyor.");
        } else {
            // Kayıtlı hayvanları numaralı liste olarak birleştir
            String icerik = "";
            for (int i = 0; i < hayvanSayisi; i++) {
                icerik = icerik + (i + 1) + ". Hayvan\n";        // "1. Hayvan"
                icerik = icerik + "-----------------------------\n";
                icerik = icerik + hayvanlar[i].toString() + "\n\n"; // toString() → nesneyi metne çevirir
            }
            metin.setText(icerik);
        }
        // JScrollPane: İçerik büyüdüğünde kaydırma çubuğu ekler.
        // JTextArea çok uzun olursa kaydırarak görebiliriz.
        pencere.add(new JScrollPane(metin));
        pencere.setVisible(true);}
    // YARDIMCI METOD: Standart Menü Butonu Oluşturucu
    // Ana menüdeki butonların tekrar eden ayarları burada bir kere yazılır.
    // Parametreler:
    // yazi → Buton üzerinde görünecek metin (emojiyle birlikte)
    // Dönüş:  Ayarlanmış JButton nesnesi
    static JButton butonOlustur(String yazi) {
        JButton btn = new JButton(yazi);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT); // Panelde yatayda ortala
        btn.setMaximumSize(new Dimension(280, 42));    // En fazla 280x42 piksel olsun
        btn.setBackground(new Color(70, 130, 180));    // RGB renk: Çelik mavi
        btn.setForeground(Color.WHITE);                // Yazı rengi: Beyaz
        btn.setFocusPainted(false);                    // Tıklanma çerçevesini gizle (daha temiz görünüm)
        return btn; // Oluşturulan ve ayarlanan butonu geri döndür
    }
}

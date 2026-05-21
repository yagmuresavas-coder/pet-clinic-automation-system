package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KullaniciGirisEkrani extends JFrame {

    private JTextField txtKullaniciAdi;
    private JPasswordField txtSifre;
    private JButton btnGiris;
    private JButton btnKayitOl;
    private JLabel lblHataMesaji;

    // Kullanıcıları tutabilmek hemde şifre ile karşılaştırarak onay mekanizması için üç paralel ArrayList kullanıyoruz
    private static ArrayList<String> kullaniciAdlari = new ArrayList<>();
    private static ArrayList<String> sifreler = new ArrayList<>();
    private static ArrayList<Owner> kullaniciDetaylari = new ArrayList<>();

    static {
        kullaniciAdlari.add("admin");
        sifreler.add("1234");
        kullaniciDetaylari.add(new Owner("Sistem", "Yöneticisi", "555-1234", "admin@petclinic.com", new Address("Klinik Cad.", "Ankara", "06000")));
    }

    public KullaniciGirisEkrani() { //giriş ekranı
        setTitle("PetClinik Randevu Sistemi - Giriş");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //bir panel oluşturuyoruz kullanıcı adı ve şifre girdisi almak için
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        /*GBC NEDİR? Java Swing'de bileşenlerin (buton, label, textfield vb.)
        ekranda nereye ve nasıl yerleşeceğini belirleyen bir ayar nesnesidir.*/
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Kullanıcı Adı:"), gbc);

        txtKullaniciAdi = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(txtKullaniciAdi, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Şifre:"), gbc);

        txtSifre = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(txtSifre, gbc);
        //alan boş bırakılırsa hata verir
        lblHataMesaji = new JLabel(" ");
        lblHataMesaji.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(lblHataMesaji, gbc);

        btnGiris = new JButton("Giriş Yap");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(btnGiris, gbc);

        btnKayitOl = new JButton("Yeni Kayıt Oluştur");
        btnKayitOl.setBackground(new Color(230, 242, 255));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(btnKayitOl, gbc);

        add(panel);

        // GİRİŞ YAP BUTONU
        btnGiris.addActionListener(new ActionListener() {//kullanıcının tıklamasını yakalıyor
            @Override
            public void actionPerformed(ActionEvent e) {
                String kAdi = txtKullaniciAdi.getText().trim();
                String sifre = new String(txtSifre.getPassword()).trim();

                // Kullanıcı adının listede kaçıncı sırada olduğunu buluyoruz
                int index = kullaniciAdlari.indexOf(kAdi);

                // index -1 değilse kullanıcı var demektir, şifreyi de kontrol ediyoruz
                if (index != -1 && sifreler.get(index).equals(sifre)) {
                    MainGUI.owner = kullaniciDetaylari.get(index);//kullanıcı girişi başarılı olduktan sonra MainGUI ye bağlanıyor ve o class çalışmaya başlıyor
                    dispose();
                    MainGUI.main(null);
                } else {
                    lblHataMesaji.setText("Hatalı kullanıcı adı veya şifre!");
                    lblHataMesaji.setForeground(Color.RED);
                }
            }
        });

        // KAYIT OL BUTONU
        btnKayitOl.addActionListener(new ActionListener() {//kullanıcının tıklamasını yakalıyor
            @Override
            public void actionPerformed(ActionEvent e) {
                kayitPenceresiAc();
            }
        });
    }

    private void kayitPenceresiAc() { //kayıt benceresi oluşturuyor
        JDialog kayitDialog = new JDialog(this, "Yeni Kayıt Oluştur", true);
        kayitDialog.setSize(450, 480);
        kayitDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //kullanıcının bilgileri alınıyor
        JTextField txtYeniKAdi = new JTextField(15);
        JPasswordField txtYeniSifre = new JPasswordField(15);
        JTextField txtAd = new JTextField(15);
        JTextField txtSoyad = new JTextField(15);
        JTextField txtTelefon = new JTextField(15);
        JTextField txtEmail = new JTextField(15);
        JTextField txtCadde = new JTextField(15);
        JTextField txtSehir = new JTextField(15);
        JTextField txtPostaKodu = new JTextField(15);

        int row = 0; //gbc.gridx değerini elle tek tek yazmak yerine sayaç mantığıyla arttırıyor

        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 1;
        panel.add(new JLabel("Kullanıcı Adı:"), gbc);
        gbc.gridx = 1; panel.add(txtYeniKAdi, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Şifre:"), gbc);
        gbc.gridx = 1; panel.add(txtYeniSifre, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Ad:"), gbc);
        gbc.gridx = 1; panel.add(txtAd, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Soyad:"), gbc);
        gbc.gridx = 1; panel.add(txtSoyad, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Telefon:"), gbc);
        gbc.gridx = 1; panel.add(txtTelefon, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("E-posta:"), gbc);
        gbc.gridx = 1; panel.add(txtEmail, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Adres (Cadde):"), gbc);
        gbc.gridx = 1; panel.add(txtCadde, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Adres (Şehir):"), gbc);
        gbc.gridx = 1; panel.add(txtSehir, gbc); row++;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Posta Kodu:"), gbc);
        gbc.gridx = 1; panel.add(txtPostaKodu, gbc); row++;
        //alanın boş bırakılmasını engelliyor
        JLabel lblDialogHata = new JLabel(" ");
        lblDialogHata.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        panel.add(lblDialogHata, gbc); row++;

        JButton btnKaydet = new JButton("Kaydol");
        btnKaydet.setBackground(new Color(230, 242, 255));
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 2;
        panel.add(btnKaydet, gbc);

        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kAdi = txtYeniKAdi.getText().trim();
                String sifre = new String(txtYeniSifre.getPassword()).trim();
                String ad = txtAd.getText().trim();
                String soyad = txtSoyad.getText().trim();
                String tel = txtTelefon.getText().trim();
                String email = txtEmail.getText().trim();
                String cadde = txtCadde.getText().trim();
                String sehir = txtSehir.getText().trim();
                String posta = txtPostaKodu.getText().trim();

                if (kAdi.isEmpty() || sifre.isEmpty() || ad.isEmpty() || soyad.isEmpty() ||
                        tel.isEmpty() || email.isEmpty() || cadde.isEmpty() || sehir.isEmpty() || posta.isEmpty()) {
                    lblDialogHata.setText("Lütfen tüm alanları doldurun!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
                //ismin doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!ad.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                    lblDialogHata.setText("Ad sadece harflerden oluşmalıdır!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
                //soyadın doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!soyad.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                    lblDialogHata.setText("Soyad sadece harflerden oluşmalıdır!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
              //telefon numarasının doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor 
                if (!tel.matches("^[0-9\\s\\-+()]+$")) {
                    lblDialogHata.setText("Geçersiz telefon numarası formatı!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
              //e-posta adresinin doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!email.matches("[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,}")) {
                    lblDialogHata.setText("Geçersiz e-posta adresi!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
                //cadde adının doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!cadde.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                    lblDialogHata.setText("Cadde adı sadece harflerden oluşmalıdır!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
              //şehir adının doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!sehir.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                    lblDialogHata.setText("Şehir adı sadece harflerden oluşmalıdır!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }
              //posta kodunun doğru formatta girilmesini sağlıyor istenmeyen karakterde uyarı veriyor
                if (!posta.matches("^[0-9]+$")) {
                    lblDialogHata.setText("Posta kodu sadece sayılardan oluşmalıdır!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }

                // Kullanıcı adı daha önce alınmış mı kontrolü
                if (kullaniciAdlari.contains(kAdi)) {
                    lblDialogHata.setText("Bu kullanıcı adı zaten alınmış!");
                    lblDialogHata.setForeground(Color.RED);
                    return;
                }

                // Üç listeye aynı anda ekliyoruz
                kullaniciAdlari.add(kAdi);
                sifreler.add(sifre);
                Address address = new Address(cadde, sehir, posta);
                Owner newOwner = new Owner(ad, soyad, tel, email, address);
                kullaniciDetaylari.add(newOwner);

                lblHataMesaji.setText("Kayıt başarılı! Şimdi giriş yapabilirsiniz.");
                lblHataMesaji.setForeground(new Color(0, 128, 0));

                txtKullaniciAdi.setText(kAdi);
                txtSifre.setText("");

                kayitDialog.dispose();
            }
        });

        kayitDialog.add(panel);
        kayitDialog.setVisible(true);
    }

    public static void main(String[] args) {//kodun çalışmaya başladığı ana kısım
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KullaniciGirisEkrani().setVisible(true);
            }
            /* main() çalışır
                → invokeLater() EDT'ye görevi gönderir
                   → run() metodu EDT'de çalışır
                     → KullaniciGirisEkrani nesnesi oluşturulur
                        → constructor içindeki tüm bileşenler hazırlanır
                           → setVisible(true) ile pencere ekrana gelir*/
        });
    }
}

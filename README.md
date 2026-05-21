# 🐾 PetClinik Randevu Sistemi

Java Swing ile geliştirilmiş masaüstü tabanlı bir veteriner klinik yönetim uygulaması.

---

## 📋 Proje Hakkında

PetClinik, evcil hayvan sahiplerinin hayvanlarını kayıt altına almasını, veteriner randevusu oluşturmasını ve tıbbi kayıtları takip etmesini sağlayan bir masaüstü uygulamasıdır. Kullanıcılar sisteme kayıt olup giriş yaptıktan sonra tüm işlemleri gerçekleştirebilir.

---

## 🚀 Özellikler

- **Kullanıcı Kayıt ve Giriş Sistemi** — Yeni hesap oluşturma ve güvenli giriş
- **Hangi Hayvan Sana Uygun? (Quiz)** — 6 soruluk quiz ile kullanıcıya en uygun hayvanı önerir
- **Hayvan Kaydı** — Köpek, kedi, kuş, balık ve at kaydı; türe özel ek bilgilerle
- **Randevu Oluşturma** — Kayıtlı hayvan ve veteriner seçerek randevu alma
- **Tıbbi Kayıt ve Aşı Takibi** — Hastalık tanısı, tedavi ve aşı geçmişi kaydı
- **Kayıtlı Hayvanları Görüntüleme** — Tüm kayıtlı hayvanların listelendiği ekran

---

## 🏗️ Proje Yapısı

```
PetClinik/
│
├── model/
│   ├── KullaniciGirisEkrani.java   # Giriş ve kayıt ekranı
│   ├── MainGUI.java                # Ana menü ve tüm alt pencereler
│   ├── Owner.java                  # Hayvan sahibi sınıfı
│   ├── Address.java                # Adres sınıfı
│   ├── Animal.java                 # Hayvan üst sınıfı
│   ├── Dog.java                    # Köpek alt sınıfı
│   ├── Cat.java                    # Kedi alt sınıfı
│   ├── Bird.java                   # Kuş alt sınıfı
│   ├── Fish.java                   # Balık alt sınıfı
│   ├── Horse.java                  # At alt sınıfı
│   ├── Appointment.java            # Randevu sınıfı
│   ├── MedicalRecord.java          # Tıbbi kayıt sınıfı
│   └── Vaccine.java                # Aşı sınıfı
│
└── staff/
    └── Veterinarian.java           # Veteriner sınıfı
```

---

## 🛠️ Kullanılan Teknolojiler

- **Java** — Temel programlama dili
- **Java Swing** — Masaüstü arayüz kütüphanesi
- **ArrayList** — Kullanıcı verilerinin bellekte tutulması
- **OOP (Nesne Yönelimli Programlama)** — Kalıtım, kapsülleme, çok biçimlilik

---

## ⚙️ Kurulum ve Çalıştırma

### Gereksinimler
- Java JDK 8 veya üzeri

### Adımlar

```bash
# 1. Projeyi klonlayın
git clone https://github.com/kullaniciadi/petclinik.git

# 2. Proje dizinine girin
cd petclinik

# 3. Derleyin
javac -d out src/model/*.java src/staff/*.java

# 4. Çalıştırın
java -cp out model.KullaniciGirisEkrani
```

---

## 👤 Varsayılan Giriş Bilgileri

Uygulamayı test etmek için aşağıdaki hesabı kullanabilirsiniz:

| Alan | Değer |
|---|---|
| Kullanıcı Adı | `admin` |
| Şifre | `1234` |

---

## 📸 Ekran Görüntüleri

<img width="523" height="541" alt="Ekran görüntüsü 2026-05-21 122153" src="https://github.com/user-attachments/assets/a7c88b5f-1fe7-43b8-985b-7e1c42ad2235" />
<img width="625" height="606" alt="Ekran görüntüsü 2026-05-21 122109" src="https://github.com/user-attachments/assets/9ce70251-6719-4a27-b2fd-c22184ce7bf3" />
<img width="547" height="390" alt="Ekran görüntüsü 2026-05-21 122104" src="https://github.com/user-attachments/assets/de82b4b5-5028-4e05-86e8-e6c3a05e8ba2" />
<img width="611" height="435" alt="Ekran görüntüsü 2026-05-21 122035" src="https://github.com/user-attachments/assets/ad97c370-373b-4d20-b6f6-2c70aca30f93" />
<img width="600" height="556" alt="Ekran görüntüsü 2026-05-21 122245" src="https://github.com/user-attachments/assets/ee6ed83e-ec35-4e40-915e-735bbacd0a87" />
<img width="587" height="467" alt="Ekran görüntüsü 2026-05-21 122239" src="https://github.com/user-attachments/assets/33de2305-cbfa-4695-96e3-8876c77e2842" />
<img width="718" height="568" alt="Ekran görüntüsü 2026-05-21 122233" src="https://github.com/user-attachments/assets/a9c97dd8-cd9a-4c04-b806-cad5c9a6807f" />
<img width="562" height="522" alt="Ekran görüntüsü 2026-05-21 122226" src="https://github.com/user-attachments/assets/11e48a3e-f5a0-4692-9a5b-a2448af24253" />
<img width="626" height="582" alt="Ekran görüntüsü 2026-05-21 122158" src="https://github.com/user-attachments/assets/c3ec4f5b-d40a-484f-b3f6-3eea59c009ee" />

---

## 📌 Notlar

- Veriler yalnızca uygulama çalışırken bellekte tutulur; program kapatılınca sıfırlanır.
- Maksimum 100 hayvan kaydı desteklenmektedir.
- Gerçek bir veritabanı entegrasyonu ilerleyen sürümlerde eklenebilir.

---

## 👨‍💻 Geliştirici

Bu proje bir ders projesi olarak Java Swing öğrenmek amacıyla geliştirilmiştir.

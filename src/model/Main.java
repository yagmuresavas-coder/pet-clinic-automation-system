package model;

import sahiplendirme.Quiz;
import sahiplendirme.ResultEvaluator;
import staff.Veterinarian;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
 
    
    //Kullanıcıyı Önceden Kayıtlı tutmak için kullanıcı nesnesi oluşturuyoruz
    static Owner owner = new Owner("Yağmur", "Rümişoğlu", "111-2222-3333", "feyza@mail.com",
            new Address("Atatürk Cad.", "İstanbul", "34000"));

    static Veterinarian[] vets = {
        new Veterinarian("Dr. Ali Yılmaz",  "ali@mail.com",    "555-111", "Veteriner Cerrahi",         new String[]{"Pazartesi", "Çarşamba", "Cuma"}),//Doktorlarımızı ve Hastaya Bakabilecekleri günleri bir diziye kaydediyoruz
        new Veterinarian("Dr. Ayşe Kaya",   "ayse@mail.com",   "555-222", "Veteriner Dahiliye",         new String[]{"Salı", "Perşembe"}),
        new Veterinarian("Dr. Mehmet Öz",   "mehmet@mail.com", "555-333", "Veteriner Acil Tıp ve Yoğun Bakım", new String[]{"Pazartesi", "Salı", "Cuma"})
    };

    // Kaydedilen hayvanları tutan dizi
    static Animal[] hayvanlar = new Animal[100];
    static int hayvanSayisi = 0;

    public static void main(String[] args) {

        while (true) { // 3 farklı sistemimiz ve bir çıkış seçeneğimiz var.Kullanıcı istediği sistemi seçiyor ve seçilen döndüye giriliyor.
            System.out.println("\n========= HANGİ SİSTEMİ TERCİH EDECEKSİNİZ ==========\n"
                    + " Evcil Hayvan Sahiplendirme[1]\n"
                    + " Veteriner Randevu Sistemi[2]\n"
                    + " Tıbbi Kayıt ve Aşı Takip Sistemi[3]\n"
                    + " Kayıtlı Hayvanları Göster[4]\n"
                    + " Çıkış[0]");
            int secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 1) {
                sahiplendirmeSistemi();
            } else if (secim == 2) {
                randevuSistemi();
            } else if (secim == 3) {
                tibbikayitSistemi();
            } else if (secim == 4) {
                hayvanlarıGoster();
            } else if (secim == 0) {
                System.out.println("Programdan çıkılıyor. Güle güle!");//burada çıkış seçildiğinde döngü bitiyor pogram sonlanıyor
                break;
            } else {//eğer istenilen girdilerden farklı bir seçenek seçilirse hata verir ve sistem tekrar seçim yapılması için başa döner 
                System.out.println("HATALI SEÇİM YAPTINIZ TEKRAR DENEYİNİZ!");
                return;
            }
        }

        scanner.close();
    }

    //1. SİSTEM: Sahiplendirme 
    private static void sahiplendirmeSistemi() { //sahiplendirme sisteminin içeriği
        Quiz quiz = new Quiz(); //yeni bir quiz nesnesi oluşturuyoruz
        quiz.start();//quizi başlatıryoruz
        ResultEvaluator evaluator = new ResultEvaluator(quiz.getTotalScores());// quiz sonucuna göre bir hayvan belirtmek için sonuç sınıfından bir sonuç nesnesi oluşturuyoruz
        evaluator.showResult();//hesaplama sonucunda çıkan hayvanı göstermek için method çağırıyoruz
    }

    //2. SİSTEM: Veteriner Randevu
    private static void randevuSistemi() { //randevu sisteminin içeriği 
        System.out.println("##################################################################\n"
                + "\tPETCLİNİC VETERİNER KLİNİĞİNE HOŞGELDİNİZ\n"
                + "##################################################################");
        System.out.println("HOŞGELDİNİZ: " + owner);
        //sistemde kayıtlı olan veterinerleri gösteriyoruz
        System.out.println("\n--- KLİNİĞİMİZDEKİ VETERİNER HEKİMLER ---");
        for (int i = 0; i < vets.length; i++) { 
            System.out.println((i + 1) + ". " + vets[i].getName()
                    + " (" + vets[i].getSpecialization() + ")"
                    + " - Çalışma Günleri: " + String.join(", ", vets[i].getWorkingDays()));
        }
        System.out.print("Hangi Veterineri Seçmek İstersiniz? (1-3): ");
        int vetChoice = scanner.nextInt();
        scanner.nextLine();
        String selectedVetName = (vetChoice >= 1 && vetChoice <= 3) ? vets[vetChoice - 1].getName() : "Bilinmiyor";

        System.out.print("\nTür Seçin (1-Köpek, 2-Kedi, 3-Kuş, 4-Balık, 5-At): ");
        int tur = scanner.nextInt();
        scanner.nextLine();
        if (tur < 1 || tur > 5) {
            System.out.println("Hata: Geçersiz tür seçtiniz!");
            return;
        }

        Animal hayvan = createAnimal(tur); //Animala extend edilen alt sınıflarda bulunan createanimal methoduyla hayvan nesnesini oluşturuyoruz.

        System.out.println("\n\n\n--- RANDEVU OLUŞTURMA EKRANI ---");
        System.out.println("Seçilen Veteriner: " + selectedVetName);
        System.out.print("Tarih (Örn: 10.05.2026): ");
        String date = scanner.nextLine();
        System.out.print("Saat (Örn: 14:30): ");
        String time = scanner.nextLine();
        System.out.print("Açıklama: ");
        String description = scanner.nextLine();

        Appointment randevu = new Appointment(date, time, hayvan, selectedVetName, description);
        System.out.println("YENİ RANDEVUNUZ: " + randevu);
    }

    // 3. SİSTEM: Tıbbi Kayıt
    private static void tibbikayitSistemi() {
        System.out.println("##################################################################\n"
                + "\tTIBBİ KAYIT VE AŞI TAKİP SİSTEMİ\n"
                + "##################################################################");

        System.out.print("Tür Seçin (1-Köpek, 2-Kedi, 3-Kuş, 4-Balık, 5-At): ");
        int tur = scanner.nextInt();
        scanner.nextLine();
        if (tur < 1 || tur > 5) {
            System.out.println("Hata: Geçersiz tür seçtiniz!");
            return;
        }

        Animal hayvan = createAnimal(tur);

        System.out.print("\nBugünün Tarihi (Örn: 10.05.2026): ");
        String date = scanner.nextLine();

        System.out.println("\n\n\n--- TIBBİ KAYIT BİLGİLERİ ---");
        System.out.print("Hastalık Tanısı: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Uygulanan Tedavi: ");
        String treatment = scanner.nextLine();

        MedicalRecord medicalRecord = new MedicalRecord(date, diagnosis, treatment, hayvan);
        System.out.println("TIBBİ KAYIT BAŞARIYLA OLUŞTURULDU: " + medicalRecord);

        System.out.println("\n--- AŞI BİLGİLERİ ---");
        System.out.print("Aşı Adı (Örn: Karma, Kuduz): ");
        String vaccineName = scanner.nextLine();
        System.out.print("Bir Sonraki Aşı Tarihi (Örn: 10.05.2027): ");
        String nextDueDate = scanner.nextLine();

        Vaccine vaccine = new Vaccine(vaccineName, date, nextDueDate, hayvan);
        System.out.println("AŞI KAYDI BAŞARIYLA OLUŞTURULDU: " + vaccine);
    }

    //4. SİSTEM: Kayıtlı Hayvanları Göster
    private static void hayvanlarıGoster() {
        if (hayvanSayisi == 0) {
            System.out.println("Henüz kayıtlı hayvan bulunmamaktadır.");
            return;
        }
        System.out.println("\n--- KAYITLI HAYVANLAR ---");
        for (int i = 0; i < hayvanSayisi; i++) {
            System.out.println("\n" + (i + 1) + ". Hayvan:");
            hayvanlar[i].displayInfo();
        }
    }

    // Oluşturduğumuz hayvanların özelliklerini doğru sınıflara atamak için
    private static Animal createAnimal(int tur) {
        Animal hayvan = null;

        if (tur == 1) {
            hayvan = Dog.create(scanner, owner);
        } else if (tur == 2) {
            hayvan = Cat.create(scanner, owner);
        } else if (tur == 3) {
            hayvan = Bird.create(scanner, owner);
        } else if (tur == 4) {
            hayvan = Fish.create(scanner, owner);
        } else {
            hayvan = Horse.create(scanner, owner);
        }

        hayvan.register();
        hayvan.displayInfo();

        // Diziye ekle
        hayvanlar[hayvanSayisi] = hayvan;
        hayvanSayisi++;

        return hayvan;
    }
}

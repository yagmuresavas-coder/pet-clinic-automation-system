package model;

import sahiplendirme.Question;
import sahiplendirme.Quiz;
import sahiplendirme.ResultEvaluator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Address address = new Address("Atatürk Cad.", "İstanbul", "34000");
		Owner owner = new Owner(" Yağmur ", " Rümişoğlu ", " 111-2222-3333 ", " feyza@mail.com ", address);
		System.out.println(
				"========= HANGİ SİSTEMİ TERCİH EDECEKSİNİZ ==========\n Evcil Hayvan Sahiplendirme[1]\n Veteriner Randevu Sistemi[2]");
		int secim = scanner.nextInt();
		scanner.nextLine(); // Satır sonu karakterini temizle

		if (secim == 1) {
			Quiz quiz = new Quiz();
			quiz.start();
			ResultEvaluator evaluator = new ResultEvaluator(quiz.getTotalScores());
			evaluator.showResult();
		} else if (secim == 2) {
			System.out.println(
					"##################################################################\n\tPETCLİNİC VETERİNER KLİNİĞİNE HOŞGELDİNİZ\n##################################################################");
			System.out.print("HOŞGELDİNİZ: " + owner + "\nTür Seçin (1-Köpek, 2-Kedi, 3-Kuş, 4-Balık, 5-At): ");
			int tur = scanner.nextInt();
			scanner.nextLine(); // Satır sonu karakterini temizle

			// Geçersiz bir seçim yapıldı mı kontrolü
			if (tur < 1 || tur > 5) {
				System.out.println("Hata: Geçersiz tür seçtiniz!");
				return; // Programı burada bitirir
			}

			// Animal Abstract sınıfı olduğu direk nesne oluşturamıyoruz
			// bird,cat,dog,horse,fish sınıflarının detayları üzerinden Animal sınıfını
			// dolduruyoruz
			System.out.print("Adı: ");
			String name = scanner.nextLine();

			System.out.print("Cinsi: ");
			String breed = scanner.nextLine();

			System.out.print("Yaş: ");
			int age = scanner.nextInt();

			System.out.print("Kilo: ");
			double weight = scanner.nextDouble();

			System.out.print("Boy: ");
			double height = scanner.nextDouble();
			scanner.nextLine(); // Satır sonu karakterini temizle

			Animal hayvan = null;

			if (tur == 1) {
				System.out.print("Eğitimi var mı? (true)Evet ,(false)Hayır: ");
				boolean trainingStatus = scanner.nextBoolean();
				scanner.nextLine();
				hayvan = new Dog(name, breed, age, weight, height, owner, trainingStatus);

				System.out.println(""
						+ "   __\r\n"
						+ " o-''|\\_____/)\r\n"
						+ "  \\_/|_)     )\r\n"
						+ "     \\  __  /\r\n"
						+ "     (_/ (_/");
				hayvan.register();
				hayvan.displayInfo();
			} else if (tur == 2) {
				System.out.print("Yaşam Alanı (true)Ev Kedisi , (false)Sokak Kedisi: ");
				boolean isIndoor = scanner.nextBoolean();
				System.out.print("Kısırlaştırıldı mı? (true)Evet ,(false)Hayır : ");
				boolean isNeutered = scanner.nextBoolean();
				scanner.nextLine();
				hayvan = new Cat(name, breed, age, weight, height, owner, isIndoor, isNeutered);
				System.out.println(""
						+ " /\\_/\\\r\n"
						+ " ( o.o )\r\n"
						+ "  > ^ <\r\n"
						+ " /  |  \\\r\n"
						+ "/___|___\\");
				hayvan.register();
				hayvan.displayInfo();
			} else if (tur == 3) {
				System.out.println("Uçabiliyor mu? (true)Evet ,(false)Hayır: ");
				boolean canFly = scanner.nextBoolean();
				scanner.nextLine();
				System.out.println("Gaga Yapısı Nasıl: ");
				String beakStructure = scanner.nextLine();
				System.out.println("Tüy Rengi: ");
				String featherColor = scanner.nextLine();
				hayvan = new Bird(name, breed, age, weight, height, owner, canFly, beakStructure, featherColor);
				System.out.println(""
						+ "   ,_,\r\n"
						+ "  (O,O)\r\n"
						+ "  (   )\r\n"
						+ "  -\"-\"-");
				hayvan.register();
				hayvan.displayInfo();
			} else if (tur == 4) {
				System.out.print("Su Tipi: ");
				String waterType = scanner.nextLine();
				System.out.println("Rengi: ");
				String color = scanner.nextLine();
				hayvan = new Fish(name, breed, age, weight, height, owner, waterType, color);
				System.out.println("><((((º>");
				hayvan.register();
				hayvan.displayInfo();
			} else {
				System.out.print("Kullanım Amacı (true)Yarış Atı, (false)Çiftlik Atı: ");
				boolean isRideable = scanner.nextBoolean();
				scanner.nextLine();
				hayvan = new Horse(name, breed, age, weight, height, owner, isRideable);
				System.out.println(""
						+ "          /|,,,/|\r\n"
						+ "         {/ ● ¿¿\\\r\n"
						+ "       { {`\\     \\\\\r\n"
						+ "      ¿{   \\   • •)\r\n"
						+ "       ¿ /   `>–'\r\n"
						+ "      |      \\   \\");
				hayvan.register();
				hayvan.displayInfo();
			}

			System.out.println("RANDEVU OLUŞTURMA EKRANI");

			System.out.print("Tarih (Örn: 10.05.2026): ");
			String date = scanner.nextLine();

			System.out.print("Saat (Örn: 14:30): ");
			String time = scanner.nextLine();

			System.out.print("Veteriner Adı: ");
			String vetName = scanner.nextLine();

			System.out.print("Açıklama: ");
			String description = scanner.nextLine();

			Appointment randevu = new Appointment(date, time, hayvan, vetName, description);

			System.out.println("YENİ RANDEVUNUZ: " + randevu);
		} else {
			System.out.println("HATALI SEÇİM YAPTINIZ TEKRAR DENEYİNİZ!");
		}

		scanner.close();
	}
}

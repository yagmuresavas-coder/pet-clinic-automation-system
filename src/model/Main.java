package model;
import sahiplendirme.Question;
import sahiplendirme.Quiz;
import sahiplendirme.ResultEvaluator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {


		Owner owner =new Owner(" Yağmur "," Rümişoğlu ", " 111-2222-3333 "," feyza@mail.com ");
		
		System.out.println("========= HANGİ SİSTEMİ TERCİH EDECEKSİNİZ ==========\n Evcil Hayvan Sahiplendirme[1]\n Veteriner Randevu Sistemi[2]");
        Scanner scanner2=new Scanner(System.in);
		int secim = scanner2.nextInt();
		
		if(secim==1)
		{
			if (secim == 1) {
			    Quiz quiz = new Quiz();
			    quiz.start();
			    ResultEvaluator evaluator = new ResultEvaluator(quiz.getTotalScores());
			    evaluator.showResult();
			}
			
		}
		else if(secim==2)     
		{
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("##################################################################\n\tPETCLİNİC VETERİNER KLİNİĞİNE HOŞGELDİNİZ\n##################################################################");
		        System.out.print("HOŞGELDİNİZ: "+owner+"\nTür Seçin (1-Köpek, 2-Kedi, 3-Kuş, 4-Balık, 5-At): ");
		        int tur = scanner.nextInt();

		        // Geçersiz bir seçim yapıldı mı kontrolü
		        if (tur < 1 || tur > 5) {
		            System.out.println("Hata: Geçersiz tür seçtiniz!");
		            return; // Programı burada bitirir
		        }

		        Scanner scanner10 = new Scanner(System.in); 
		        // Animal Abstract sınıfı olduğu direk nesne oluşturamıyoruz bird,cat,dog,horse,fish sınıflarının detayları üzerinden Animal sınıfını dolduruyoruz
		        System.out.print("Adı: ");
		        String name = scanner10.nextLine();

		        Scanner scanner11= new Scanner(System.in);
		        System.out.print("Cinsi: ");
		        String breed = scanner11.nextLine();

		        Scanner scanner12= new Scanner(System.in);
		        System.out.print("Yaş: ");
		        int age = scanner12.nextInt();

		        Scanner scanner13 = new Scanner(System.in);
		        System.out.print("Kilo: ");
		        double weight = scanner13.nextDouble();

		        Scanner scanner14 = new Scanner(System.in);
		        System.out.print("Boy: ");
		        double height = scanner14.nextDouble();




		        Animal hayvan;
		        
		        if (tur == 1) 
		        {	
		        	Scanner scanner1 = new Scanner(System.in);
		        	System.out.print("Eğitimi varmı? (true)Evet ,(false)Hayır: ");
			        boolean trainingStatus = scanner1.nextBoolean();
		            hayvan = new Dog(name, breed, age, weight, height, owner,trainingStatus);
		            
		            System.out.println(""
		            		+ "   __\r\n"
		            		+ " o-''|\\_____/)\r\n"
		            		+ "  \\_/|_)     )\r\n"
		            		+ "     \\  __  /\r\n"
		            		+ "     (_/ (_/"
		            		+ "\n"
		            		+ "Sisteme bir Köpek kaydedildi."+hayvan);
		        } 
		        else if (tur == 2) 
		        {
		        	Scanner scanner1 = new Scanner(System.in);
		        	System.out.print("Yaşam Alanı (true)Ev Kedisi , (false)Sokak Kedisi: ");
			        boolean isIndoor = scanner1.nextBoolean();
			        Scanner scanner3 = new Scanner(System.in);
		        	System.out.print("Kısırlaştırıldımı? (true)Evet ,(false)Hayır : ");
			        boolean isNeutered = scanner1.nextBoolean();
		            hayvan = new Cat(name, breed, age, weight, height, owner, isIndoor,isNeutered);
		            System.out.println(""
		            		+ " /\\_/\\\r\n"
		            		+ " ( o.o )\r\n"
		            		+ "  > ^ <\r\n"
		            		+ " /  |  \\\r\n"
		            		+ "/___|___\\"
		            		+ "\n"
		            		+ "Sisteme bir Kedi kaydedildi."+hayvan);
		        } 
		        else if (tur == 3) 
		        {
		        	Scanner scanner1 = new Scanner(System.in);
		        	System.out.println("Uçabiliyormu? (true)Evet ,(false)Hayır: ");
			        boolean canFly = scanner1.nextBoolean();
			        Scanner scanner4 = new Scanner(System.in);
		        	System.out.println("Gaga Yapısı Nasıl: ");
			        String beakStructure = scanner1.nextLine();
		        	System.out.println("Tüy Rengi: ");
			        String featherColor = scanner1.nextLine();
		            hayvan = new Bird(name, breed, age, weight, height, owner,canFly,beakStructure,featherColor);
		            System.out.println(""
		            		+ "   ,_,\r\n"
		            		+ "  (O,O)\r\n"
		            		+ "  (   )\r\n"
		            		+ "  -\"-\"-"
		            		+ "\n"
		            		+ "Sisteme bir Kuş kaydedildi."+hayvan);
		        } 
		        else if (tur == 4) 
		        {
		        	Scanner scanner1 = new Scanner(System.in);
		        	System.out.print("Su Tipi: ");
		            String waterType = scanner1.nextLine();
	        	    System.out.println("Rengi: ");
		            String color = scanner1.nextLine();
		            hayvan = new Fish(name, breed, age, weight, height, owner,waterType,color);
		            System.out.println("><((((º>"
		            		+ "\n"
		            		+ "Sisteme bir Balık kaydedildi."+hayvan);
		        } 
		        else 
		        {
		        	Scanner scanner1 = new Scanner(System.in);
		        	System.out.print("Kullanım Amacı (true)Yarış Atı, (false)Çiftlik Atı: ");
			        boolean isRideable = scanner1.nextBoolean();
		            hayvan = new Horse(name, breed, age, weight, height, owner,isRideable);
		            System.out.println(""
		            		+ "          /|,,,/|\r\n"
		            		+ "         {/ ● ¿¿\\\r\n"
		            		+ "       { {`\\     \\\\\r\n"
		            		+ "      ¿{   \\   • •)\r\n"
		            		+ "       ¿ /   `>–'\r\n"
		            		+ "      |      \\   \\"
		            		+ "\n"
		            		+ "Sisteme bir At kaydedildi."+hayvan);
		        }
		        
		        System.out.println("RANDEVU OLUŞTURMA EKRANI");
		        
		    	Scanner scanner5 =new Scanner(System.in);
		    	System.out.print("rehgıuregıer:");
		        String date=scanner5.nextLine();
		        
		        Scanner scanner6 =new Scanner(System.in);
		    	System.out.print("hgrhegıhregeru:");
		        String time=scanner6.nextLine();
		        
		        Scanner scanner7 =new Scanner(System.in);
		    	System.out.print("rherheheth:");
		        String vetName=scanner7.nextLine();
		        
		        Scanner scanner8 =new Scanner(System.in);
		    	System.out.print("herherherh:");
		        String description=scanner8.nextLine();
		        
		       // Scanner scanner9 =new Scanner(System.in);
		    	/*System.out.print("rherherherh");
		        String patient=scanner9.nextLine();*/
		        
		      
		        
		    	Appointment randevu = new Appointment (date,time,hayvan,vetName,description);
		    	
		    	System.out.println("YENİ RANDEVUNUZ: "+randevu);
		}	
		
	
		else
		{ 
			System.out.println("HATALI SEÇİM YAPTINIZ TEKRAR DENEYİNİZ!");
			return;
		}
	}
}


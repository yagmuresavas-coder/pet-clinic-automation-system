package model;

public class Dog extends Animal{
//Köpeğin ekstra özellikleri.	
	private boolean trainingStatus;
	
	// Constructor:Temel bilgileri aldık.
		public Dog(String name,String breed, int age, double weight, double height, Owner owner, boolean trainingStatus) {
			super (name,  breed, age, weight, height,owner);
			this.trainingStatus=trainingStatus;
		}
    public static Dog create(Scanner scanner, Owner owner) {
		        System.out.print("Adı: ");
		        String name = scanner.nextLine();
		        System.out.print("Cinsi: ");
		        String breed = scanner.nextLine();
		        int age;
				while (true) {
				    System.out.print("Yaş: ");
				    age = scanner.nextInt();
				    if (age >= 0) break;
				    System.out.println("Hata: Yaş negatif değer olamaz! Tekrar girin.");
				}

				double weight;
				while (true) {
				    System.out.print("Kilo: ");
				    weight = scanner.nextDouble();
				    if (weight >= 0) break;
				    System.out.println("Hata: Kilo negatif olamaz! Tekrar girin.");
				}

				double height;
				while (true) {
				    System.out.print("Boy: ");
				    height = scanner.nextDouble();
				    if (height >= 0) break;
				    System.out.println("Hata: Boy negatif olamaz! Tekrar girin.");
				}
		        scanner.nextLine();
		        System.out.print("Eğitimi var mı? (true)Evet ,(false)Hayır: ");
				boolean trainingStatus = scanner.nextBoolean();
				scanner.nextLine();
				System.out.println(""
						+ "   __\r\n"
						+ " o-''|\\_____/)\r\n"
						+ "  \\_/|_)     )\r\n"
						+ "     \\  __  /\r\n"
						+ "     (_/ (_/");
				 return new Dog(name, breed, age, weight, height,owner,trainingStatus);
		 }
	@Override
	public String getType() {
		return "Köpek";
	}

	@Override
	public String toString() 
	{ String dogInfo=super.toString();
		if(this.trainingStatus == true){
			dogInfo += "\nEğitimlimi : " + "Evet";
		}else{
			dogInfo += "\nEğitimlimi : " + "Hayır";
		}
		return dogInfo;
	}

//---GETTER ve SETTER---// 	
	public boolean getTrainingStatus() {
		return trainingStatus;
	}
	
	public void setTrainingStatus(boolean trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	
	// Köpeğin özellikleri ekrana yazdırılır.
		@Override
		public void displayInfo() {
			System.out.println(this.toString());
		}
}



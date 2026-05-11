package model;

public class  Bird extends Animal {
// Kuşun ekstra özellikleri.
	 private boolean canFly;
	 private String beakStructure;
	 private String featherColor;
	 
	// Constructor : Temel bilgileri aldık.
		public Bird(String name, String breed,  int age, double weight, double height , Owner owner, boolean canFly ,String beakStructure ,String featherColor) {		
			super(name, breed, age, weight, height,owner);
			this.canFly=canFly;
			this.beakStructure=beakStructure;
			this.featherColor=featherColor;
		}
	 public static Bird create(Scanner scanner, Owner owner)
		 {
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
		        scanner.nextLine();
			   System.out.println("Uçabiliyor mu? (true)Evet ,(false)Hayır: ");
				boolean canFly = scanner.nextBoolean();
				scanner.nextLine();
				System.out.println("Gaga Yapısı Nasıl: ");
				String beakStructure = scanner.nextLine();
				System.out.println("Tüy Rengi: ");
				String featherColor = scanner.nextLine();
				
				System.out.println(""
						+ "   ,_,\r\n"
						+ "  (O,O)\r\n"
						+ "  (   )\r\n"
						+ "  -\"-\"-");
				 return new Bird(name, breed, age, weight, height, owner, canFly,beakStructure, featherColor);
		    }	
	@Override
	public String getType() {
		return "Kuş";
	}

	// super.toString() ile üst sınıftaki (Animal) temel bilgileri aldık.
	// Üzerine kuşa özel bilgileri ekliyoruz.	
		@Override
		public String toString() {
			String birdInfo = super.toString();
			if(this.canFly == true) {
				birdInfo += "\nUçabiliyor mu ? " + "Evet";
			}else {
				birdInfo += "\nUçabiliyor mu ? " + "Hayır";
			}
			birdInfo += "\nGaga yapısı : " + beakStructure;
			birdInfo += "\nTüy rengi : " + featherColor;
			
		return birdInfo;
}	
		
//---GETTER ve SETTER---//
public String getBeakStructure() {
	return beakStructure;
}

public void setBeakStructure(String beakStructure) {
	this.beakStructure = beakStructure;
}

public boolean isCanFly() {
	return canFly;
}

public void setCanFly(boolean canFly) {
	this.canFly = canFly;
}
public String getFeatherColor() {
	return featherColor;
}
public void setFeatherColor(String featherColor) {
	this.featherColor = featherColor;
}
//Kuşun özellikleri ekrana yazdırılır.		
	@Override
public void displayInfo() {
	System.out.println(this.toString());
			
}

	
	}


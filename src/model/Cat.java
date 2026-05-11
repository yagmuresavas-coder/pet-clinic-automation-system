package model;

public class Cat extends Animal {
	// Kedinin ekstra özellikleri.
	private boolean isIndoor;
	private boolean isNeutered;
	
	// Constructor: ile temel bilgileri aldık.
		public Cat(String name, String breed,  int age, double weight, double height , Owner owner, boolean isIndoor , boolean isNeutered) {
			super(name, breed, age, weight, height ,owner);
			 this.isIndoor=isIndoor;
			 this.isNeutered=isNeutered;
		}
      public static Cat create(Scanner scanner,Owner owner)
   {
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
   	System.out.print("Yaşam Alanı (true)Ev Kedisi , (false)Sokak Kedisi: ");
	boolean isIndoor = scanner.nextBoolean();
	System.out.print("Kısırlaştırıldı mı? (true)Evet ,(false)Hayır : ");
	boolean isNeutered = scanner.nextBoolean();
	scanner.nextLine();
	System.out.println(""
			+ " /\\_/\\\r\n"
			+ " ( o.o )\r\n"
			+ "  > ^ <\r\n"
			+ " /  |  \\\r\n"
			+ "/___|___\\");
	
	return new Cat(name,breed,age,weight,height,owner,isIndoor,isNeutered);
   }
	@Override
	public String getType() {
		return "Kedi";
	}

	@Override
	public String toString() {
		String catInfo = super.toString();
		if(this.isIndoor == true){
			catInfo += "\nYaşam alanı : " + " Ev kedisi ";
		}else{
			catInfo += "\nYaşam alanı : " + " Sokak kedisi ";
		}
		if(this.isNeutered == true){
			catInfo += "\nKısırlaştırılmış : " + "Evet";
		}else{
			catInfo += "\nKısırlaştırılmış : " + "Hayır";
		}
		return catInfo;
	}		
	
	//---GETTER ve SETTER---//

	public boolean isIndoor() {
		return isIndoor;
	}

	public void setIndoor(boolean isIndoor) {
		this.isIndoor = isIndoor;
	}
	public boolean isNeutered() {
		return isNeutered;
	}
	public void setNeutered(boolean isNeutered) {
		this.isNeutered= isNeutered;
	}
	
	// Ekrana yazdıran yöntem.
		@Override
		public void displayInfo() {
			System.out.println(this.toString());
		}
}
	
	
	
	
		
	



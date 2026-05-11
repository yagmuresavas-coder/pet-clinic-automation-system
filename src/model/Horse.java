package model;

public class Horse extends Animal {
// Atın ekstra özellikleri.	
	private boolean isRideable;
	
	//Constructor: Temel bilgileri aldık.
		public Horse(String name, String breed,  int age, double weight, double height ,Owner owner, boolean isRideable) {
			super(name, breed, age, weight, height,owner);
			this.isRideable=isRideable;
		}
     public static Horse create(Scanner scanner, Owner owner) {
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
		        System.out.print("Kullanım Amacı (true)Yarış Atı, (false)Çiftlik Atı: ");
		        boolean isRideable = scanner.nextBoolean();
		        scanner.nextLine();
		 
		        System.out.println("     "
		        		+ "     /|,,,/|\n    "
		        		+ "     {/ ● ¿¿\\\n  "
		        		+ "     { {`\\    "
		        		+ " \\\\\n    "
		        		+ "  ¿{   \\   • •)\n   "
		        		+ "    ¿ /   `>–'\n    "
		        		+ "  |      \\   \\");
		 
		        
		        return new Horse(name, breed, age, weight, height, owner, isRideable);
		    }
	@Override
	public String getType() {
		return "At";
	}

	@Override
	public String toString() {
		String horseInfo = super.toString();
		if(this.isRideable == true) {
			horseInfo += "\nKullanım amacı: " + "Yarış atı";
		}else {
			horseInfo += "\nKullanım amacı: " + "Çiftlik atı"; 
		}
				return horseInfo;
	}

	//---GETTER ve SETTER---//
	public boolean isRideable() {
		return isRideable;
	}
	public void setRideable(boolean isRideable) {
		this.isRideable=isRideable;
	}
	
	// Ekrana yazdıran metot.
		@Override
		public void displayInfo() {
			System.out.println(this.toString());
		}
}	
	

	

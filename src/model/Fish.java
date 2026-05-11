package model;

public class Fish extends Animal{
// Balığın ekstra özellikleri.	
	private String waterType;
	private String color;
	
	//Constructor: Temel bilgileri aldık.
		public Fish(String name, String breed, int age, double weight, double height , Owner owner, String waterType, String color) {
			super(name, breed, age, weight, height,owner);
			this.waterType=waterType;
			this.color=color;
		}
	public static Fish create(Scanner scanner, Owner owner) {
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
	        System.out.print("Su Tipi: ");
	        String waterType = scanner.nextLine();
	        System.out.print("Rengi: ");
	        String color = scanner.nextLine();
	 
	        System.out.println("><((((º>");
	 
	        return new Fish(name, breed, age, weight, height, owner, waterType, color);
	    }				
	@Override
	public String getType() {
		return "Balık";
	}

	@Override
	public String toString() {
		String fishInfo = super.toString();
		fishInfo += "\nSu tipi: " + waterType;
		fishInfo += "\nRenk: " + color;
		return fishInfo;
	}

//---GETTER ve SETTER---// 	
	public String getWaterType() {
		return waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	
	// Özellikleri ekrana yazdırır.	
	    @Override
		public void displayInfo() {
			System.out.println(this.toString());
		}
	

}

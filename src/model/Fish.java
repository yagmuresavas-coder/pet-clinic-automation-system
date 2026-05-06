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
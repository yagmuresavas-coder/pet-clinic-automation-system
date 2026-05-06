package model;

public class Horse extends Animal {
// Atın ekstra özellikleri.	
	private boolean isRideable;
	
	//Constructor: Temel bilgileri aldık.
		public Horse(String name, String breed,  int age, double weight, double height ,Owner owner, boolean isRideable) {
			super(name, breed, age, weight, height,owner);
			this.isRideable=isRideable;
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
	

	
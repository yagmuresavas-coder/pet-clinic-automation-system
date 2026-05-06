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
	
	
	
	
		
	



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


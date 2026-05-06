package model;

public class Dog extends Animal{
//Köpeğin ekstra özellikleri.	
	private boolean trainingStatus;
	
	// Constructor:Temel bilgileri aldık.
		public Dog(String name,String breed, int age, double weight, double height, Owner owner, boolean trainingStatus) {
			super (name,  breed, age, weight, height,owner);
			this.trainingStatus=trainingStatus;
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



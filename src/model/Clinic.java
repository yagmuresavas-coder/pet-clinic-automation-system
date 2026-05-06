package model;

public class Clinic { // Veteriner kliniği için kontrol sınıfı
	private static int patientnumber = 0; // hasta sayısı kontrolü
	public static void incrementCount() {
		patientnumber++;
	}
	public static int hastanumarasigir() { //?
		return patientnumber;
		
	}
}
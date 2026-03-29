package model;

public class Clinic {
	private static int patientnumber = 0;
	public static void sayaciarttir() {
		patientnumber++;
	}
	public static int hastanumarasigir() {
		return patientnumber;
		
	}
}

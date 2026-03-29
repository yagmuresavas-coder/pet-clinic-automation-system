package model;

public class Main {

	public static void main(String[] args) {
	Address adres= new Address("ATATÜRK CADDESİ" ," ANKARA" ," 06000");
	
	Owner hayvansahip =new Owner(" Yağmur "," Rümişoğlu ", " 111-2222-3333 "," feyza@mail.com ", adres);
	Appointment c1 = new Appointment("01.04.2026", "10:00", hayvansahip);
	System.out.println(c1);
	Appointment c2 = new Appointment("01.04.2026", "11.00", hayvansahip, "Dr.Feyzanur Rümişoğlu");
	System.out.println(c2);
	Appointment c3 = new Appointment("01.04.2026", "12:00", hayvansahip, "Dr.Rümeysa Kabagil", "Rutin Kontrol");
	System.out.println(c3);
	
	System.out.println(hayvansahip.getFullName());
	System.out.println(hayvansahip);
	
	}
	

	}


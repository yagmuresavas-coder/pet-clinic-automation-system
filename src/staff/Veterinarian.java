package staff;
import İnterfaces.Schedulable;
import model.Appointment;

public class Veterinarian extends StaffMember implements Schedulable {
private String specialization;
private String[]workingDays;

Appointment appointments [] = new Appointment[20];
private int appointmentCount=0;

public Veterinarian(String name, String email, String phone, String specialization, String[] workingDays ) {
	super(name, email, phone);
	this.specialization = specialization;
	this.workingDays=workingDays;
}
@Override
public void listAppointments() {
	if( appointmentCount == 0) {
		System.out.println("Henüz alınmış randevu bulunmamaktadır.");
	}else {
	for(int i=0; i<appointmentCount; i++) {
		System.out.println("Randevu : " + (i+1));
		System.out.println(appointments[i].toString());
}
	}
}
@Override
public boolean isAvailable(String date , String time) {
	boolean dayFound = false;	
	for(int i=0; i<workingDays.length; i++) {
		if(workingDays[i].equals(date)) {
			dayFound=true;
		}
	}
	   if(dayFound==false) {
		   return false;
	   }
	
for (int i =0; i<appointmentCount; i++) {
	if(appointments [i].getDate().equals(date) && appointments [i].getTime().equals(time)){
		return false;
	}	
}
		return true;
}	

@Override
public void addAppointment(Appointment newApp) {
	if(isAvailable ( newApp.getDate(), newApp.getTime()) && appointmentCount<20) {
			appointments[appointmentCount] = newApp;
			appointmentCount++;
			System.out.println("Randevunuz başarıyla alınmıştır.");
	}else {
		System.out.println("Randevunuz alınamadı.");
	}
}
//--- GETTER ve SETTER ---//
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
public int getAppointmentCount() {
	return appointmentCount;
}
public void setAppointmentCount(int appointmentCount) {
	this.appointmentCount = appointmentCount;
}
public String[] getWorkingDays() {
	return workingDays;
}
public void setWorkingDays(String[] workingDays) {
	this.workingDays=workingDays;
}

@Override
public String toString() {
	return super.toString() + "\nUzmanlık: " + specialization;
}

@Override
public void register() {
	super.register();
	System.out.println("Veteriner sisteme kaydedildi.");
}

@Override
public void displayInfo() {
	System.out.println( this.toString() );
   }

}

 


	


 
	 

	

	
	






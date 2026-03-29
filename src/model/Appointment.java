package model;

public class Appointment {
private String date;
private String time;
private String description;
private String vetName;
private Object patient;

public Appointment(String date,String time,Object patient) {
this.date=date;
this.time=time;
this.patient=patient;
}
public Appointment(String date,String time,Object patient,String vetName) {
	this.date=date;
	this.time=time;
	this.patient=patient;
	this.vetName=vetName;
}
public Appointment(String date,String time,Object patient,String vetName,String description) {
	this.date=date;
	this.time=time;
	this.patient=patient;
	this.vetName=vetName;
	this.description=description;
}
public String toString() {
	return " Tarih: " + date +  " Saat: "  + time +  "  Sahip: " + patient + "  Veteriner:" + vetName +  " " + " Açıklama: " + description;
}
}

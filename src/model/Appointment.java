package model;

public class Appointment { //Evcil hayvan için veterinerden randevu oluşturuyoruz
private String date; //? neden private bide tarih saat niye string
private String time;
private String description;
private String vetName;
private Animal patient;
public String getDate() {return date;};
public String getTime() {return time;};
public Appointment(String date,String time,Animal patient,String vetName,String description) {
	this.date=date;
	this.time=time;
	this.patient=patient;
	this.vetName=vetName;
	this.description=description;
}
public String toString() { //atadığımız değişkenleri kullanıcının görmesi için yazdırıyoruz 
	return " Tarih: " + date +  " Saat: "  + time  + patient + "  Veteriner:" + vetName +  " " + " Açıklama: " + description;
}
}

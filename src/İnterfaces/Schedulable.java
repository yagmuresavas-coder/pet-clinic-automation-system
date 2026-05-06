package İnterfaces;

import model.Appointment; // model paketindeki Appointment sınıfını dahil ettik

public interface Schedulable
{
boolean isAvailable(String date,String time); 
public void addAppointment(Appointment randevu); //Randevu oluşturmak bölümü appointment sınıfını çağırarak dahil ettik
public void listAppointments(); //oluşturulan randevuları gösterir
}

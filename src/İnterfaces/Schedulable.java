package İnterfaces;

public interface Schedulable {
boolean isAvailable(String date,String time);
void addAppointment(Appointment randevu);
void listAppointments();
}

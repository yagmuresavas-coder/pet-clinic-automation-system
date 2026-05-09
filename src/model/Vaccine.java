package model;

/**
 * Vaccine (Aşı) sınıfı, kliniğe gelen hastaların (hayvanların) aşı takibini yapmak için kullanılır.
 */
public class Vaccine {
	private String vaccineName; // Aşının adı (Örn: Kuduz, Karma)
	private String date; // Aşının yapıldığı tarih
	private String nextDueDate; // Bir sonraki aşı tarihi
	private Animal patient; // Aşıyı olan hasta (hayvan)
	
	/**
	 * Constructor (Kurucu Metot)
	 * Yeni bir aşı kaydı oluşturulurken temel bilgileri alır.
	 * 
	 * @param vaccineName Aşının adı
	 * @param date Aşının vurulduğu tarih
	 * @param nextDueDate Bir sonraki aşı dozu/tarihi
	 * @param patient Aşılanan hayvan
	 */
	public Vaccine(String vaccineName, String date, String nextDueDate, Animal patient) {
		this.vaccineName = vaccineName;
		this.date = date;
		this.nextDueDate = nextDueDate;
		this.patient = patient;
	}

	/**
	 * Aşının gecikip gecikmediğini kontrol eder.
	 * String compareTo kullanarak tarih karşılaştırması yapar.
	 * (Not: Gerçek projelerde LocalDate kullanımı daha sağlıklıdır, ancak örnek için String kullanılmıştır.)
	 * 
	 * @param today Bugünün tarihi (Karşılaştırma için)
	 * @return Eğer sonraki aşı tarihi bugünden küçükse (geçmişse) true döndürür.
	 */
	public boolean isOverdue(String today) {
	    return nextDueDate.compareTo(today) < 0;
	}

	/**
	 * Aşı bilgilerini okunabilir bir metin olarak döndürür.
	 */
	@Override
	public String toString() {
	    return "Aşı: " + vaccineName + "  Tarih: " + date + " Sonraki: " + nextDueDate;
	}
}

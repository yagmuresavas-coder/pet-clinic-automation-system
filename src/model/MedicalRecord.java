package model;

/**
 * MedicalRecord (Tıbbi Kayıt) sınıfı, kliniğe gelen hastaların (hayvanların) 
 * geçmiş tedavi ve teşhislerini (tıbbi geçmişini) tutmak için kullanılır.
 * Bağlı liste (linked list) mantığına benzer şekilde, her kayıt bir önceki kaydı (previousRecord) tutar.
 */
public class MedicalRecord {
	private String date; // Kaydın oluşturulduğu tarih
    private String diagnosis; // Konulan teşhis/tanı
    private String treatment; // Uygulanan tedavi
    private Animal patient; // Tedavi gören hasta
    private MedicalRecord previousRecord; // Bu hastaya ait bir önceki tıbbi kayıt
    
    /**
     * Constructor (Kurucu Metot)
     * Yeni bir tıbbi kayıt oluşturulurken gerekli bilgileri alır.
     * 
     * @param date Kayıt tarihi
     * @param diagnosis Teşhis (Tanı)
     * @param treatment Tedavi yöntemi
     * @param patient Hasta
     */
    public MedicalRecord(String date, String diagnosis, String treatment, Animal patient) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.patient = patient;
    }
        
    public MedicalRecord getPreviousRecord() {
        return previousRecord;
    }

    public void setPreviousRecord(MedicalRecord previousRecord) {
        this.previousRecord = previousRecord;
    }

    /**
     * Tıbbi kayıt detaylarını okunabilir bir metin olarak döndürür.
     */
    @Override
    public String toString() {
        return "Tarih: " + date + "  Tanı: " + diagnosis + "  Tedavi: " + treatment;
    }
}

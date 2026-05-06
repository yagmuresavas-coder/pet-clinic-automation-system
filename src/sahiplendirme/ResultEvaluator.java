package sahiplendirme;

public class ResultEvaluator {

    private String[] hayvanIsimleri = {"Köpek", "Kedi", "Balık", "Kuş"}; //hayvan isimlerinin olduğu dizi
    private int[] puanlar;

    //  (Constructor) seçimlerden puanları topluyor
    public ResultEvaluator(int[] gelenPuanlar) {
        this.puanlar = gelenPuanlar;
    }

    public void showResult() {
        System.out.println("\n--- TEST SONUÇLARI ---");

        // Her hayvanın puanını ekrana yazdıralırır
        for (int i = 0; i < puanlar.length; i++) {
            System.out.println(hayvanIsimleri[i] + ": " + puanlar[i] + " puan");
        }

        // puan sırasına göre hayvan belirlediğimiz için 0 la 3 arasında en yüksek puanı alanı buluyoruz
        int enYuksekPuanIndeksi = 0;
        for (int i = 1; i < puanlar.length; i++) {
            if (puanlar[i] > puanlar[enYuksekPuanIndeksi]) {
                enYuksekPuanIndeksi = i;
            }
        }

        System.out.println("\nSana en uygun hayvan arkadaşın:");
        
        // Kazananı ekrana bastırır
        String kazananHayvan = hayvanIsimleri[enYuksekPuanIndeksi];
        
        if (enYuksekPuanIndeksi == 0) {
            System.out.println("🐶 " + kazananHayvan.toUpperCase());
            System.out.println("Aktif, sosyal ve sadık bir yapın var.");
            System.out.println("Öneri: Golden Retriever veya Beagle");
        } 
        else if (enYuksekPuanIndeksi == 1) {
            System.out.println("🐱 " + kazananHayvan.toUpperCase());
            System.out.println("Bağımsız ama şefkatli bir yapıyı tercih ediyorsun.");
            System.out.println("Öneri: British Shorthair veya Van Kedisi");
        } 
        else if (enYuksekPuanIndeksi == 2) {
            System.out.println("🐟 " + kazananHayvan.toUpperCase());
            System.out.println("Huzurlu ve sakin bir yaşam tarzın var.");
            System.out.println("Öneri: Japon Balığı veya Betta");
        } 
        else {
            System.out.println("🐦 " + kazananHayvan.toUpperCase());
            System.out.println("Neşeli sesleri ve canlılığı seviyorsun.");
            System.out.println("Öneri: Muhabbet Kuşu veya Kanarya");
        }

        System.out.println("\nİyi şanslar!");
    }
}
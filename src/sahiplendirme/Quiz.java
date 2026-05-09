
package sahiplendirme;

import java.util.Scanner;

public class Quiz {
   private Question[] questions;//boş soru dizisi
   private int[] totalScores = new int[4];//boş toplam sonuç dizisi
   private Scanner scanner;//?

   public Quiz() {
      this.scanner = new Scanner(System.in); //Kullanıcıya soracağımız soruları ve soruların puan değerlerinin olduğu diziyi oluşturuyoruz
      this.questions = new Question[6];
      this.questions[0] = new Question("Günlük ne kadar aktif birisin?", new String[]{"Çok aktifim, hareketi seviyorum", "Orta seviye, bazen dışarı çıkarım", "Evde oturmayı tercih ederim"}, new int[][]{{3, 0, 0, 0}, {1, 2, 0, 0}, {0, 2, 2, 1}});
      this.questions[1] = new Question("Evde ne kadar zaman geçiriyorsun?", new String[]{"Çoğunlukla evdeyim", "Yarı yarıya", "Çok az zaman geçiriyorum"}, new int[][]{{0, 2, 2, 2}, {1, 1, 0, 0}, {0, 0, 3, 1}});
      this.questions[2] = new Question("Hayvanınla ne tür bir bağ kurmak istersin?", new String[]{"Sarılmak, oynamak, yakın temas", "Birlikte vakit geçirmek ama bağımsız olsun", "İzlemek ve bakımını yapmak yeterli"}, new int[][]{{3, 0, 0, 0}, {0, 3, 0, 0}, {0, 0, 3, 2}});
      this.questions[3] = new Question("Yaşadığın yer nasıl?", new String[]{"Büyük ev veya bahçeli", "Normal büyüklükte daire", "Küçük daire"}, new int[][]{{3, 0, 0, 0}, {1, 2, 0, 1}, {0, 1, 3, 2}});
      this.questions[4] = new Question("Hayvana ne kadar zaman ve para ayırabilirsin?", new String[]{"Çok fazla, sorun değil", "Orta düzeyde", "Az, düşük bakım isterim"}, new int[][]{{3, 0, 0, 0}, {0, 3, 0, 1}, {0, 0, 3, 0}});
      this.questions[5] = new Question("Ses ve gürültüyü nasıl karşılarsın?", new String[]{"Sorun değil, canlı bir ev severim", "Biraz ses tamam ama aşırı olmasın", "Sessiz bir ortam tercih ederim"}, new int[][]{{2, 0, 0, 2}, {0, 2, 0, 1}, {0, 1, 3, 0}});
   }

   public void start() {
      System.out.println(",_     _\r\n |\\\\_,-~/\r\n / _  _ |    ,--.\r\n(  @  @ )   / ,-'\r\n \\  _T_/-._( (\r\n /         `. \\\r\n|         _  \\ |\r\n \\ \\ ,  /      |\r\n  || |-_\\__   /\r\n ((_/`(____,-'\n KİŞİSEL HAYVAN SAHİPLENDİRME  ║");
      System.out.println("Sana en uygun hayvan arkadaşını bulmak için");
      System.out.println(this.questions.length + " soru soracağız.\n");

      for(int deger1 = 0; deger1 < this.questions.length; ++deger1) {
         this.askQuestion(deger1);
      }

   }

   private void askQuestion(int deger1) {
      Question deger2  = this.questions[deger1];
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.println("Soru " + (deger1 + 1) + "/" + this.questions.length);
      System.out.println(deger2.getQuestionText());
      String[] deger3 = deger2.getOptions();

      for(int deger4 = 0; deger4 < .length; ++deger4) {
         System.out.println("  " + (deger4 + 1) + ") " + deger3[deger4]);
      }

      int deger7 = this.readInput(1, deger3.length) - 1;
      int[] deger5 = deger2.getScoresForAnswer(deger7);

      for(int deger6 = 0; deger6 < this.totalScores.length; ++deger6) {
         int[] deger10000 = this.totalScores;
         deger10000[deger6] += deger5[deger6];
      }

   }

   private int readInput(int deger1, int deger2) {
      while(true) {
         System.out.print("Cevabınız (" + deger1 + "-" + deger2 + "): ");

         try {
            int deger3 = Integer.parseInt(this.scanner.nextLine().trim());
            if (deger3 >= deger1 && deger3 <= deger2) {
               return deger3;
            }
         } catch (NumberFormatException deger4) {
         }

         System.out.println("⚠️  Lütfen " + deger1 + " ile " + deger2 + " arasında bir sayı girin.");
      }
   }

   public int[] getTotalScores() {
      return this.totalScores;
   }
}

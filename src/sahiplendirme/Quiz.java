package sahiplendirme;

import java.util.Scanner;

public class Quiz {

    private Question[] questions;
    private int[] totalScores; // 0:köpek, 1:kedi, 2:balık, 3:kuş
    private Scanner scanner;

    public Quiz() {
        this.totalScores = new int[4];
        this.scanner = new Scanner(System.in);
        this.questions = new Question[6];

        questions[0] = new Question( //kişisel sorular
            "Günlük ne kadar aktif birisin?",
            new String[]{
                "Çok aktifim, hareketi seviyorum",
                "Orta seviye, bazen dışarı çıkarım",
                "Evde oturmayı tercih ederim"
            },
            new int[][]{  //bunlar seçilen soruların puan değerleri
                {3, 0, 0, 0},
                {1, 2, 0, 0},
                {0, 2, 2, 1}
            }
        );

        questions[1] = new Question(
            "Evde ne kadar zaman geçiriyorsun?",
            new String[]{
                "Çoğunlukla evdeyim",
                "Yarı yarıya",
                "Çok az zaman geçiriyorum"
            },
            new int[][]{
                {0, 2, 2, 2},
                {1, 1, 0, 0},
                {0, 0, 3, 1}
            }
        );

        questions[2] = new Question(
            "Hayvanınla ne tür bir bağ kurmak istersin?",
            new String[]{
                "Sarılmak, oynamak, yakın temas",
                "Birlikte vakit geçirmek ama bağımsız olsun",
                "İzlemek ve bakımını yapmak yeterli"
            },
            new int[][]{
                {3, 0, 0, 0},
                {0, 3, 0, 0},
                {0, 0, 3, 2}
            }
        );

        questions[3] = new Question(
            "Yaşadığın yer nasıl?",
            new String[]{
                "Büyük ev veya bahçeli",
                "Normal büyüklükte daire",
                "Küçük daire"
            },
            new int[][]{
                {3, 0, 0, 0},
                {1, 2, 0, 1},
                {0, 1, 3, 2}
            }
        );

        questions[4] = new Question(
            "Hayvana ne kadar zaman ve para ayırabilirsin?",
            new String[]{
                "Çok fazla, sorun değil",
                "Orta düzeyde",
                "Az, düşük bakım isterim"
            },
            new int[][]{
                {3, 0, 0, 0},
                {0, 3, 0, 1},
                {0, 0, 3, 0}
            }
        );

        questions[5] = new Question(
            "Ses ve gürültüyü nasıl karşılarsın?",
            new String[]{
                "Sorun değil, canlı bir ev severim",
                "Biraz ses tamam ama aşırı olmasın",
                "Sessiz bir ortam tercih ederim"
            },
            new int[][]{
                {2, 0, 0, 2},
                {0, 2, 0, 1},
                {0, 1, 3, 0}
            }
        );
    }

    public void start() {
        System.out.println(",_     _\r\n"
        		+ " |\\\\_,-~/\r\n"
        		+ " / _  _ |    ,--.\r\n"
        		+ "(  @  @ )   / ,-'\r\n"
        		+ " \\  _T_/-._( (\r\n"
        		+ " /         `. \\\r\n"
        		+ "|         _  \\ |\r\n"
        		+ " \\ \\ ,  /      |\r\n"
        		+ "  || |-_\\__   /\r\n"
        		+ " ((_/`(____,-'"
        		+ "\n"
        		+ " KİŞİSEL HAYVAN SAHİPLENDİRME  ║");
        System.out.println("Sana en uygun hayvan arkadaşını bulmak için");
        System.out.println(questions.length + " soru soracağız.\n");

        for (int i = 0; i < questions.length; i++) {
            askQuestion(i);
        }
    }

    private void askQuestion(int index) {
        Question q = questions[index];

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📍 Soru " + (index + 1) + "/" + questions.length);
        System.out.println(q.getQuestionText());

        String[] opts = q.getOptions();
        for (int i = 0; i < opts.length; i++) {
            System.out.println("  " + (i + 1) + ") " + opts[i]);
        }

        int answer = readInput(1, opts.length) - 1;

        int[] gained = q.getScoresForAnswer(answer);
        for (int i = 0; i < totalScores.length; i++) {
            totalScores[i] += gained[i];
        }
    }

    private int readInput(int min, int max) {
        while (true) {
            System.out.print("Cevabınız (" + min + "-" + max + "): ");
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val >= min && val <= max) return val;
            } catch (NumberFormatException ignored) {}
            System.out.println("⚠️  Lütfen " + min + " ile " + max + " arasında bir sayı girin.");
        }
    }

    public int[] getTotalScores() {
        return totalScores;
    }
}
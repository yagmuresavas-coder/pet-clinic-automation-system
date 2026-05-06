package sahiplendirme;

public class Question {

    private String questionText;
    private String[] options;
    // scores[cevapIndex][hayvanIndex] -> 0:köpek, 1:kedi, 2:balık, 3:kuş
    private int[][] scores;

    public Question(String questionText, String[] options, int[][] scores) {
        this.questionText = questionText;
        this.options = options;
        this.scores = scores;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int[] getScoresForAnswer(int answerIndex) {
        return scores[answerIndex];
    }

    public int getOptionCount() {
        return options.length;
    }
}
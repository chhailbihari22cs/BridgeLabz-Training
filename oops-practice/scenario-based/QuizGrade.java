public class QuizGrade {

    public static void main(String[] args) {

        String[] correctAnswers = {
                "A", "C", "B", "D", "A", "B", "C", "D", "A", "B"
        };

        String[] studentAnswers = {
                "A", "c", "B", "A", "A", "b", "C", "D", "C", "B"
        };

        int score = findScore(correctAnswers, studentAnswers);

        System.out.println("\nTotal Score: " + score + " / " + correctAnswers.length);

        double percentage = (score * 100.0) / correctAnswers.length;
        System.out.println("Percentage: " + percentage + "%");

        System.out.println(percentage >= 40 ? "Result: PASS" : "Result: FAIL");
    }

    public static int findScore(String[] correctAnswers, String[] studentAnswers) {

        int score = 0;

        System.out.println("Quiz Feedback:\n");

        int length = Math.min(correctAnswers.length, studentAnswers.length);

        for (int i = 0; i < length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }
}

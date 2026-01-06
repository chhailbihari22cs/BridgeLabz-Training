import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class QuizPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] correctAnswers = { "A", "B", "C", "D", "A" };
        QuizProcessor processor = new QuizProcessor(correctAnswers);

        System.out.print("Enter number of users taking the quiz: ");
        int users = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int u = 1; u <= users; u++) {

            System.out.println("\nUser " + u + ":");
            String[] userAnswers = new String[correctAnswers.length];

            for (int i = 0; i < correctAnswers.length; i++) {
                System.out.print("Answer for Q" + (i + 1) + ": ");
                userAnswers[i] = sc.nextLine().trim();

                if (userAnswers[i].isEmpty()) {
                    userAnswers[i] = " "; // safe fallback
                }
            }

            try {
                int score = processor.calculateScore(userAnswers);
                String grade = processor.getGrade(score);
                System.out.println("Score: " + score + "/" + correctAnswers.length +
                        " | Grade: " + grade);
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nAll users' scores: " + processor.getScores());
        sc.close();
    }
}

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    private String[] correctAnswers;
    private List<Integer> scores = new ArrayList<>();

    public QuizProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int calculateScore(String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Number of answers does not match quiz length!");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }

        scores.add(score);
        return score;
    }

    public String getGrade(int totalScore) {
        double percentage = (totalScore * 100.0) / correctAnswers.length;

        if (percentage >= 90)
            return "A+";
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else
            return "F";
    }

    public List<Integer> getScores() {
        return scores;
    }
}

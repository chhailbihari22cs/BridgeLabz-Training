
import java.util.*;

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class ScoreAnalyser {

    public static void main(String[] args) {
        double scores[] = { 85, 65, 78, 35, 64, 95, 25 };
        try {
            validateScores(scores);

            System.out.println("Average Score: " + averageScore(scores));
            System.out.println("Highest Score: " + maxScore(scores));
            System.out.println("Lowest Score: " + minScore(scores));

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void validateScores(double scores[]) throws InvalidScoreException {
        for (double score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException("Invalid score found: " + score);
            }
        }
    }

    public static double averageScore(double scores[]) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return (sum / scores.length);
    }

    public static double maxScore(double scores[]) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            max = Math.max(max, scores[i]);
        }
        return max;
    }

    public static double minScore(double scores[]) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < scores.length; i++) {
            min = Math.min(min, scores[i]);
        }
        return min;
    }

}

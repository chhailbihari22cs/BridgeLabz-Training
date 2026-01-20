import java.util.*;

public class ExamProctor {
    // QuestionID -> Answer
    private HashMap<Integer, String> studentAnswers = new HashMap<>();
    
    // QuestionID -> Correct Answer (Answer Key)
    private HashMap<Integer, String> answerKey = new HashMap<>();
    
    // Stack for tracking navigation history
    private Stack<Integer> navigationStack = new Stack<>();

    public ExamProctor() {
        // Sample Answer Key setup
        answerKey.put(1, "A");
        answerKey.put(2, "C");
        answerKey.put(3, "B");
    }

    // 1. Question Visit Karna (Stack)
    public void visitQuestion(int questionID) {
        navigationStack.push(questionID);
        System.out.println("Viewing Question: " + questionID);
    }

    // 2. Answer Store Karna (HashMap)
    public void submitAnswer(int questionID, String answer) {
        studentAnswers.put(questionID, answer);
        System.out.println("Answer saved for Q" + questionID + ": " + answer);
    }

    // 3. Last Visited Question pe wapas jana (Stack Backtrack)
    public void goBack() {
        if (navigationStack.size() > 1) {
            navigationStack.pop(); // Current wala hatao
            int previous = navigationStack.peek(); // Pichle wale ko dekho
            System.out.println("Navigated back to Question: " + previous);
        } else {
            System.out.println(" No previous history!");
        }
    }

    // 4. Auto-Calculate Score (Function Logic)
    public void calculateFinalScore() {
        int score = 0;
        for (int qID : answerKey.keySet()) {
            if (studentAnswers.containsKey(qID) && 
                studentAnswers.get(qID).equalsIgnoreCase(answerKey.get(qID))) {
                score++;
            }
        }
        System.out.println("\n--- Exam Result ---");
        System.out.println("Total Score: " + score + "/" + answerKey.size());
    }

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();

        // Simulating Student Activity
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "B"); // Wrong answer (Correct is C)

        exam.visitQuestion(3);
        exam.goBack(); // Back to Q2

        exam.submitAnswer(3, "B"); // Back to Q3 and answer

        // Final Submission
        exam.calculateFinalScore();
    }
}
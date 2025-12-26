
import java.util.Scanner;

public class Pooling_Booth_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;
        int totalVoters = 0;
        
        System.out.println("<-----ELECTION BOOTH MANAGER----->");
        System.out.println("Candidates: 1, 2, 3");
        System.out.println("Enter -1 to exit and show results\n");
        
        while (true) {
            System.out.print("Enter voter's age (or -1 to exit): ");
            int age = sc.nextInt();
            
            // exit condition
            if (age == -1) {
                break;
            }
            
            // Check eligibility
            if (age >= 18) {
                System.out.print("You are eligible! Enter your vote (1, 2, or 3): ");
                int vote = sc.nextInt();
                
                if (vote == 1) {
                    candidate1Votes++;
                    totalVoters++;
                    System.out.println("Vote recorded for Candidate 1!\n");
                } else if (vote == 2) {
                    candidate2Votes++;
                    totalVoters++;
                    System.out.println("Vote recorded for Candidate 2!\n");
                } else if (vote == 3) {
                    candidate3Votes++;
                    totalVoters++;
                    System.out.println("Vote recorded for Candidate 3!\n");
                } else {
                    System.out.println("Invalid vote!!! Please vote for 1, 2, or 3.\n");
                }
            } else {
                System.out.println(" You are not eligible to vote because you are below 18\n");
            }
        }
        
        // Display results
        System.out.println("\n<----- ELECTION RESULTS ----->");
        System.out.println("Total Voters: " + totalVoters);
        System.out.println("Candidate 1: " + candidate1Votes + " votes");
        System.out.println("Candidate 2: " + candidate2Votes + " votes");
        System.out.println("Candidate 3: " + candidate3Votes + " votes");
    }
}

// 1. MealPlan Interface and Subtypes
interface MealPlan {
    String getPlanDetails();
    boolean isValidForUser(String healthGoal);
}

class VegetarianMeal implements MealPlan {
    public String getPlanDetails() { return "Diet: Paneer, Lentils, Veggies, and Dairy."; }
    public boolean isValidForUser(String goal) { return goal.equalsIgnoreCase("Weight Loss") || goal.equalsIgnoreCase("Maintenance"); }
}

class KetoMeal implements MealPlan {
    public String getPlanDetails() { return "Diet: High Fat, Low Carb (Avocado, Nuts, Meat)."; }
    public boolean isValidForUser(String goal) { return goal.equalsIgnoreCase("Fat Loss"); }
}

class HighProteinMeal implements MealPlan {
    public String getPlanDetails() { return "Diet: Lean Meat, Eggs, Protein Shakes."; }
    public boolean isValidForUser(String goal) { return goal.equalsIgnoreCase("Muscle Gain"); }
}

// 2. Generic Class with Bounded Type Parameter
class Meal<T extends MealPlan> {
    private String userName;
    private T plan;

    public Meal(String userName, T plan) {
        this.userName = userName;
        this.plan = plan;
    }

    public T getPlan() { return plan; }
    public String getUserName() { return userName; }

    @Override
    public String toString() {
        return "User: " + userName + " | " + plan.getPlanDetails();
    }
}

// 3. Main Generator Class
public class MealGenerator {

    // 4. Generic Method to validate and generate plan dynamically
    // <T extends MealPlan> ensures the method only works with valid meal types
    public static <T extends MealPlan> void generatePlan(String user, T planType, String goal) {
        System.out.println("Processing request for " + user + "...");
        
        if (planType.isValidForUser(goal)) {
            Meal<T> personalizedMeal = new Meal<>(user, planType);
            System.out.println("SUCCESS: Meal Plan Generated!");
            System.out.println(personalizedMeal);
        } else {
            System.out.println("FAILED: " + planType.getClass().getSimpleName() + " is not suitable for the goal: " + goal);
        }
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Personalized Meal Plan Generator ===\n");

        // Case 1: Valid Muscle Gain plan
        generatePlan("Rahul", new HighProteinMeal(), "Muscle Gain");

        // Case 2: Valid Fat Loss plan
        generatePlan("Simran", new KetoMeal(), "Fat Loss");

        // Case 3: Invalid plan (Keto for Weight Loss - according to our logic)
        generatePlan("Amit", new KetoMeal(), "Weight Loss");

        // Case 4: Valid Vegetarian plan
        generatePlan("Priya", new VegetarianMeal(), "Weight Loss");
    }
}
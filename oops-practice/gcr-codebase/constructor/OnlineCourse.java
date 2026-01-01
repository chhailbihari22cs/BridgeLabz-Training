
class Course {
    // Instance variables
    String courseName;
    int duration; // in months
    double fee;

    // Class variable
    static String instituteName = "Vantage Academy";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println(courseName + " | " + duration +
                " months | Fee: ₹" + fee +
                " | Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class OnlineCourse {
    public static void main(String[] args) {
        Course c1 = new Course("Python", 2, 5000);
        c1.displayCourseDetails();
    }
}

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class RepeatableAnnotationDemo {

    // Container annotation
    @Retention(RetentionPolicy.RUNTIME)
    @interface BugReports { BugReport[] value(); }

    // Repeatable annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(BugReports.class)
    @interface BugReport { String description(); }

    // Class with repeatable annotation
    static class TaskManager {
        @BugReport(description = "NullPointerException")
        @BugReport(description = "UI freeze on submit")
        void performTask() {
            System.out.println("Task executed");
        }
    }

    public static void main(String[] args) throws Exception {
        Method m = TaskManager.class.getMethod("performTask");

        // Print all bug reports
        for (BugReport b : m.getAnnotationsByType(BugReport.class)) {
            System.out.println("Bug: " + b.description());
        }

        // Invoke the method
        new TaskManager().performTask();
    }
}

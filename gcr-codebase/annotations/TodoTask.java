import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectManager {

    @Todo(task = "Implement login feature", assignedTo = "Harshdeep", priority = "HIGH")
    void loginFeature() {
        System.out.println("Login feature in progress...");
    }

    @Todo(task = "Add search functionality", assignedTo = "Aman")
    void searchFeature() {
        System.out.println("Search feature pending...");
    }

    void completedFeature() {
        System.out.println("Completed feature");
    }
}

public class TodoTask {

	public static void main(String[] args) {
		Class<ProjectManager> cls = ProjectManager.class;

        System.out.println("Pending Tasks:");

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName() +
                                   ", Task: " + todo.task() +
                                   ", Assigned To: " + todo.assignedTo() +
                                   ", Priority: " + todo.priority());
            }
        }

	}

}

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfoo {
    int priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfoo(priority = 1, assignedTo = "Harshdeep")
    public void performTask() {
        System.out.println("Performing important task...");
    }
}

public class TaskInfo {

	public static void main(String[] args) throws Exception{
		
		Class<TaskManager> cls = TaskManager.class;
        Method method = cls.getMethod("performTask");

        if (method.isAnnotationPresent(TaskInfoo.class)) {
            TaskInfoo task = method.getAnnotation(TaskInfoo.class);
            System.out.println("Priority: " + task.priority());
            System.out.println("Assigned To: " + task.assignedTo());
        }

	}

}

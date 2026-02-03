import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}


class PriorityManager {

    @ImportantMethod
    void performTask() {
        System.out.println("Performing main task...");
    }

    @ImportantMethod(level = "MEDIUM")
    void secondaryTask() {
        System.out.println("Performing secondary task...");
    }

    void normalTask() {
        System.out.println("Performing normal task...");
    }
}

public class ImportantMethodDemo {

	public static void main(String[] args) throws Exception {
		Class<PriorityManager> cls = PriorityManager.class;

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + im.level());
            }
        }

	}

}

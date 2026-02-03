import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class PerformanceTest {

    @LogExecutionTime
    void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class CheckExecutionTime {

	public static void main(String[] args) throws Exception{
		PerformanceTest test = new PerformanceTest();
        Class<?> cls = test.getClass();

        for (Method method : cls.getDeclaredMethods()) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();

                method.invoke(test);

                long end = System.nanoTime();

                System.out.println(
                    method.getName() + " executed in " + (end - start) + " ns"
                );
            }
        }

	}

}

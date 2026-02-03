import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class MathService {

    @CacheResult
    public int slowSquare(int n) {
        System.out.println("Computing square for " + n);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n * n;
    }
}

class CacheExecutor {

    private static Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object obj, String methodName, Object... args) throws Exception {

        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, int.class);

        String key = methodName + args[0]; // simple cache key

        if (method.isAnnotationPresent(CacheResult.class)) {

            if (cache.containsKey(key)) {
                System.out.println("Returning cached result");
                return cache.get(key);
            }

            Object result = method.invoke(obj, args);
            cache.put(key, result);
            return result;
        }

        return method.invoke(obj, args);
    }
}


public class CacheResultDemo {

	public static void main(String[] args) throws Exception{
		MathService service = new MathService();

        System.out.println(CacheExecutor.execute(service, "slowSquare", 5));
        System.out.println(CacheExecutor.execute(service, "slowSquare", 5));
        System.out.println(CacheExecutor.execute(service, "slowSquare", 6));

	}

}

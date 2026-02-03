import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserTwo {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password;

    public UserTwo(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}



class JsoonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                if (!first) {
                    json.append(", ");
                }

                json.append("\"")
                    .append(annotation.name())
                    .append("\": \"")
                    .append(field.get(obj))
                    .append("\"");

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
}


public class JsonSerializer {

	public static void main(String[] args) throws Exception{
		UserTwo user = new UserTwo("harshdeep", 22, "secret123");

        String json = JsoonSerializer.toJson(user);
        System.out.println(json);

	}

}

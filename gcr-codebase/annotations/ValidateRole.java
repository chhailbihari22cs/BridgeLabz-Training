import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

@RoleAllowed("ADMIN")
class AdminService {

    void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }
}

public class ValidateRole {
	static String currentUserRole = "USER";
	public static void main(String[] args) throws Exception{
		
		Class<AdminService> cls = AdminService.class;

        if (cls.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);

            if (roleAllowed.value().equals(currentUserRole)) {
                
                AdminService service = new AdminService();
                service.performAdminTask();
            } else {
                
                System.out.println("Access Denied!");
            }
        }

	}

}

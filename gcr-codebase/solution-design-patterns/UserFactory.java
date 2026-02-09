public class UserFactory {

    public static User createUser(String role, String name) {

        if (role.equalsIgnoreCase("STUDENT"))
            return new Student(name);

        if (role.equalsIgnoreCase("FACULTY"))
            return new Faculty(name);

        if (role.equalsIgnoreCase("LIBRARIAN"))
            return new Librarian(name);

        throw new IllegalArgumentException("Invalid role");
    }
}

public class Student extends User {

    public Student(String name) {
        super(name);
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + name + " notified: " + message);
    }
}

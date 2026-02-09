public class Faculty extends User {

    public Faculty(String name) {
        super(name);
    }

    @Override
    public void update(String message) {
        System.out.println("Faculty " + name + " notified: " + message);
    }
}

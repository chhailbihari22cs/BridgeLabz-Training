import java.util.ArrayList;

public class SuppressWarningsDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();

        list.add("Hello");
        list.add("World");
        list.add(100);

        for (Object obj : list) {
            System.out.println(obj);
        }

	}

}

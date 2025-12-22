public class NPEdemo {
    static void genEx() {
        String t = null;
        System.out.println(t.length()); // generates NPE
    }

    static void handleEx() {
        String t = null;
        try {
            System.out.println(t.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NPE: " + e);
        }
    }

    public static void main(String[] args) {
        // genEx(); //uncomment to see abrupt stop
        handleEx();
    }
}

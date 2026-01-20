public class StringPerformance {

    public static void main(String[] args) {
        int n = 100000; // Hum 1 lakh baar concatenate karenge

        // 1. Using String (Immutable - Sabse slow)
        // Savdhani: 1 million (10 lakh) par ye hang ho jayega, isliye 1 lakh use kar
        // rahe hain
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 1000000.0 + " ms");

        // 2. Using StringBuilder (Fastest - Recommended)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1000000.0 + " ms");

        // 3. Using StringBuffer (Thread-safe - Slightly slower than StringBuilder)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1000000.0 + " ms");
    }
}
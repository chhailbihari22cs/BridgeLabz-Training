public class InvoiceGenerator {

    public static void main(String[] args) {

        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        String[] tasks = parseInvoice(input);
        int totalAmount = calculateTotalAmount(tasks);

        System.out.println("Invoice Details:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        System.out.println("Total Invoice Amount: " + totalAmount + " INR");
    }

    public static String[] parseInvoice(String input) {
        return input.split(",");
    }

    public static int calculateTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");

            if (parts.length > 1) {
                String amountPart = parts[1];
                String amountStr = amountPart.replaceAll("[^0-9]", "");
                total += Integer.parseInt(amountStr);
            }
        }
        return total;
    }
}

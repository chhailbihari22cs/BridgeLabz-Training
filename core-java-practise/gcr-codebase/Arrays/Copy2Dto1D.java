import java.util.*;

public class Copy2Dto1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();

        int[][] matrix = new int[r][c];
        System.out.println("Enter elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] arr = new int[r * c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");
        for (int val : arr)
            System.out.print(val + " ");
    }
}

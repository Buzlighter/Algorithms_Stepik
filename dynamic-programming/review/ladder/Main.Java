import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(ladderMaxSum(A,n));
    }

    public static int ladderMaxSum(int [] A, int n) {
        for (int i = 2; i <= n; i++) {
            A[i] += Math.max(A[i - 1],A[i - 2]);
        }
        return A[n];
    }
}
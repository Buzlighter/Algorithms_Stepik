import java.util.*;

public class Main {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] num = s.split("\\D+");
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(num[i]);
        }
        knapsack(W, w, n);
    }

    public static void knapsack(int W, int[] w, int n) {
        int [] D = new int[W+1];
        D[0] = 1;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = W; i >= w[j]; i--) {
                if(D[i - w[j]] == 1) {
                    D[i] = 1;
                }
            }
        }
        for (int i = W; i >= 0; i--) {
            if(D[i] != 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
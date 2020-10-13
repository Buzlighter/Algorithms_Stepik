import java.util.*;

public class Main {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int n = s1.length();
        int m = s2.length();
        char [] A;
        char [] B;
        A = s1.toCharArray();
        B = s2.toCharArray();
        System.out.println(EditDist(A, B, n, m));
    }
    public static int EditDist(char [] A, char [] B, int n, int m) {
        int [][] D = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            D[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int c = diff(A[i - 1], B[j - 1]);
                D[i][j] = Math.min(Math.min(D[i - 1][j] + 1, D[i][j - 1] + 1), D[i - 1][j - 1] + c);
            }
        }
        return D[n][m];
    }
    public static int diff(char a, char b) {
        if (a == b) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
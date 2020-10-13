import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] A = new int[n + 1];
        ArrayList<Integer> answer = new ArrayList();
        MinOfCalc(A,n);
        int k = A[n];
        restoringRaw(A,answer,n,k);
        System.out.println(k);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(String.format(answer.get(i) + " "));
        }

    }

    public static void MinOfCalc(int [] A, int n) {
        for (int i = 2; i <= n; i++) {
            Integer minimum = A[i - 1] + 1 ;
            if (i % 2 == 0) minimum = Math.min(minimum, A[i/2] + 1);
            if (i % 3 == 0) minimum = Math.min(minimum, A[i/3] + 1);
            A[i] = minimum;

        }
    }
    public static void restoringRaw(int [] A, ArrayList<Integer> answer, int n, int k) {
        answer.add(n);
        for (int i = n; i >= 1; i--) {
            if (i % 3 == 0 && A[i/3] == k - 1) {
                answer.add(i / 3);
                k--;
                i = (i / 3) + 1;
            }
            else {
                if (A[i - 1] == k - 1) {
                    answer.add(i - 1);
                    k--;
                }
                else if (i % 2 == 0 && A[i/2] == k - 1) {
                    answer.add(i / 2);
                    k--;
                    i = (i / 2) + 1;
                }
            }
        }
        Collections.reverse(answer);
    }
}
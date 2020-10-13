import java.util.*;

public class Main {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList <Integer> D = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            A.add(a);
        }
        LISBottomUp(A, D, n);
        System.out.println(makeSequence(A, D, n));
    }
    public static int LISBottomUp(ArrayList<Integer> A, ArrayList<Integer> D, Integer n) {

        for (int i = 0; i < n; i++) {
            D.set(i,1);
            for (int j = 0; j < i; j++) {
                if(A.get(j) <= A.get(i) && D.get(j) + 1 > D.get(i) && A.get(i) % A.get(j) == 0) {
                    D.set(i, D.get(j) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, D.get(i));
        }
        return ans;
    }
    public static int makeSequence(ArrayList<Integer> A, ArrayList<Integer> D, Integer n) {
        ArrayList<Integer> Seq = new ArrayList<>();
        int maximum = ans;
        int currentIndexOfAns = 0;
        int prevIndexOfAns = 0;
        for (int i = D.indexOf(ans); i >= 0; i--) {
            if(ans + 1 > maximum) {
                Seq.add(A.get(i));
                prevIndexOfAns = i;
                ans--;
            }
            else {
                if(D.get(i) == ans) {
                    currentIndexOfAns = i;
                    if(A.get(currentIndexOfAns) <= A.get(prevIndexOfAns)) {
                        Seq.add(A.get(i));
                        ans--;
                    }
                    prevIndexOfAns = currentIndexOfAns;
                }
            }
        }
        return Seq.size();
    }
}
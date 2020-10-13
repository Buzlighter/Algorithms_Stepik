import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        Integer sizeOfB = 0;
        for (int i = 0; i < n; i++) {
            Integer numbers = scanner.nextInt();
            A.add(numbers);
        }
        // Solution
        sizeOfB = Collections.max(A);
        ArrayList<Integer> B = new ArrayList<>(Collections.nCopies(sizeOfB,0));
        for (int i = 0; i < n; i++) {
            int element = B.get(A.get(i)-1);
            B.set(A.get(i)-1, ++element);
        }
        List<Integer> C = Arrays.asList(new Integer[n]);
        int i = n - 1;
        for(int j = B.size() - 1; j >= 0; j--) {
            for (int k = 0; k < B.get(j); k++) {
                C.set(i, j + 1);
                i--;
            }
            if (i == 0) {
                break;
            }
        }
        // Output
        for (Integer num: C) {
            System.out.print(num + " ");
        }
    }
}
import java.util.*;

public  class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        /* М - массив, содержащий индексы наименьших по величине
         из последних элементов ННП(наидлиннейшая невозврастающая подпоследоватльность);
         */
        int[] M = new int[n + 1];
        /* Р - массив, содержащий индекс предшествующего  элемента
         для ННП, оканчивающийчя в i;
         */
        int[] P = new int[n];

        makeLDS(M, A, P, n);

        // ans - массив, который будет возвращать длину ННП и индекс последнего элемента ННП;
        int ans [] = new int[2];
        answerLIS(M, ans, n);

        int answer = ans[0];
        int lastIndex = ans[1];

        System.out.println(answer);
        // IndexesLDS - массив, который содержит индексы ННП;
        List IndexesLDS = new ArrayList();
        IndexesLDS.add(lastIndex + 1);
        int i = lastIndex;

        while (answer > 1) {
            IndexesLDS.add(P[i] + 1);
            i = P[i];
            answer--;
        }
        Collections.reverse(IndexesLDS);
        for (int j = 0; j < IndexesLDS.size(); j++) {
            System.out.print(String.format(IndexesLDS.get(j) + " "));
        }

    }

    public static void makeLDS(int[] M, int[] A, int[] P, Integer n) {
        int L = 0;
        //двоичный поиск;
        for (int i = 0; i < n; i++) {
            int lo = 1;
            int hi = L;
            while (lo <= hi) {
                Integer mid = lo + ((hi - lo) / 2);
                if (A[M[mid]] < A[i]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            /* newL хранит текущий максимум подпоследовательности длины i
             и соответствующий индекс M[newL] конечного числа;
             */
            int newL = lo;
            P[i] = M[newL - 1];
            M[newL] = i;
            if (newL > L) {
                L = newL;
            }
        }
    }
    public static int [] answerLIS(int [] M, int [] ans, int n) {

        for (int i = M.length - 1; i >= 0; i--) {
            if (n == 1) {
                ans[0]++;
                break;
            }
            if(M[i] > 0) {
                ans[0] = i;
                ans[1] = M[i];
                break;
            }
        }
        return ans;
    }
}
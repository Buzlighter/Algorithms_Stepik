import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a =0, b =1, c = 0;
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        System.out.println(Fib(n, a, b, c));
    }

    public static int Fib(Integer n, int a, int b, int c) {
        c = a + b;
        a = b;
        b = c;
        if (n <= 2) {
            return c;
        }
        else if (n == 0 || n == 1) {
            return 1;
        }
        return Fib(n - 1, a, b, c);
    }
}
 
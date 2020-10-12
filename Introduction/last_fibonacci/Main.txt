import java.util.Scanner;
import java.lang.Exception;

public class Main {

    public static void main(String[] args) {
        Integer a, b, d = 0;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        GCD(a,b,d);

        System.out.println(GCD(a,b,d));
    }
    public static int GCD(Integer a, Integer b, Integer d)  {
    try {
        d = a % b;
        if(a % b == 0) {
            return b;
        }
        a = b;
        b = d;
    }
    catch(ArithmeticException e) {
        System.out.println(0);
        System.exit(0);
    }
    return GCD(a,b,d);
 }
}
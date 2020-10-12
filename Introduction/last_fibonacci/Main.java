import java.util.Scanner;

class Main {
   public static void main(String[] args) {
        Integer  a =0, b =1, c = 0;
        int n = 1, i = 2;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n == 1 || n == 2) {
            System.out.println(1);
        }
        while (i <= n) {
            c = (a + b)%10;
            a = b;
            b = c;
            i++;
        }
        
        System.out.println(c);
    }
 }
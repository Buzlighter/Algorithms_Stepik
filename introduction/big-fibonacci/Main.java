import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int m = 2, elements = 0, T = 0, remainder = 0;
        long n = 1;
        Scanner in = new Scanner(System.in);
        n = in.nextLong();
        m = in.nextInt();
        int [] arr = new int[6*m];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <=6*m; i++) {
                arr[i] = (arr[i - 2] + arr[i - 1]) % m;
                T++;
            if(arr[i - 1] == 0 && arr[i] == 1)
                break;
        }
     
        remainder = (int) (n % T);
        System.out.println(arr[remainder]);
    }
}
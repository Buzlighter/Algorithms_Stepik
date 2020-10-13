import java.util.*;

public class Main {
    public static int switchSortMaxMin = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        Integer a, b, x;
        int [] arrayOfDot = new int [m];
        int [] leftOfSegments = new int[n];
        int [] rightOfSegments = new int [n];
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            leftOfSegments[i] = a;
            rightOfSegments[i] = b;
        }

        for (int i = 0; i < m; i++) {
            x = scanner.nextInt();
            arrayOfDot[i] = x;
        }

        Arrays.sort(leftOfSegments);
        Arrays.sort(rightOfSegments);

        for (int i = 0; i < rightOfSegments.length / 2; i++) {
            int temp = rightOfSegments[i];
            rightOfSegments[i] = rightOfSegments[rightOfSegments.length - 1 - i];
            rightOfSegments[rightOfSegments.length - 1 - i] = temp;
        }
        for (Integer dot : arrayOfDot) {
            System.out.print(binSearch(leftOfSegments, rightOfSegments, dot) + " ");
        }
    }


    public static Integer binSearch(int [] leftOfSegments,
                                    int [] rightOfSegments, Integer dot) {
        int left = 0;
        int right = leftOfSegments.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (dot > leftOfSegments[middle]) {
                left = middle + 1;
            }
            else if (dot < leftOfSegments[middle]){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        int rangeA = right + 1;
        left = 0;
        right = rightOfSegments.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (dot > rightOfSegments[middle]) {
                right = middle - 1;
            }
            else if (dot < rightOfSegments[middle]){
                left = middle + 1;
            }
            else {
                left = middle + 1;
            }
        }
        int rangeB = rightOfSegments.length - (right + 1);
        if(rangeA - rangeB <= 0) {
            return 0;
        }
        else {
            return rangeA - rangeB;
        }
    }
}
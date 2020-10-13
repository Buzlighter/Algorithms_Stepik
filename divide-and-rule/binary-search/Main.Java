import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        scanner.nextLine();
        Integer k = scanner.nextInt();
        ArrayList<Integer> B = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            B.add(scanner.nextInt());
        }
        for (Integer element: B) {
            System.out.print(binSearch(element, A) + " ");
        }
    }

    public static Integer binSearch(Integer element, ArrayList<Integer> arrayList) {
        int left = 0;
        int right = arrayList.size() - 1;
        while(left <= right) {
            int middle = left + ((right - left)/2);
            if (arrayList.get(middle).equals(element)) {
                return middle + 1;
            }
            else if (arrayList.get(middle) > element) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return - 1;
    }
}
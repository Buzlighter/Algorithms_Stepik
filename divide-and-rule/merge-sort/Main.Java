import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AtomicLong transposition = new AtomicLong(0);
        Integer n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer number = scanner.nextInt();
            arrayList.add(number);
        }
        mergeSort(arrayList,transposition);
        System.out.println(transposition);
    }

    public static void mergeSort(ArrayList<Integer> arrayList, AtomicLong transposition) {
        Integer left = 0;
        Integer right = arrayList.size() - 1;
        mergeSort(arrayList, left, right,transposition);
    }

    public static void mergeSort(ArrayList<Integer> arrayList, Integer left,
                                 Integer right, AtomicLong transposition) {
        if (left < right) {
            Integer middle = (left + right) / 2;
            mergeSort(arrayList, left, middle,transposition);
            mergeSort(arrayList, middle + 1, right,transposition);
            merge(arrayList,left,middle,right,transposition);
        }
    }
    public static void merge (ArrayList<Integer> arrayList, Integer left,Integer middle,
                              Integer right,AtomicLong transposition) {
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        /** fill array **/
        for (int i = left; i <= middle; i++) {
            leftArr.add(arrayList.get(i));
        }
        for (int j = middle+1; j <= right; j++) {
            rightArr.add(arrayList.get(j));
        }

        Integer leftIndex = 0;
        Integer rightIndex = 0;

        for (int i = left; i <= right; i++) {
            if (leftArr.size() > leftIndex && rightArr.size() > rightIndex) {
                if (leftArr.get(leftIndex) <= rightArr.get(rightIndex)) {
                    arrayList.set(i, leftArr.get(leftIndex));
                    leftIndex++;
                } else {
                    arrayList.set(i, rightArr.get(rightIndex));
                    rightIndex++;
                    transposition.addAndGet(leftArr.size() - leftIndex);
                }
            } else if (rightIndex < rightArr.size()) {
                arrayList.set(i, rightArr.get(rightIndex));
                rightIndex++;
            } else if (leftIndex < leftArr.size()) {
                arrayList.set(i, leftArr.get(leftIndex));
                leftIndex++;

            }
        }
    }
}
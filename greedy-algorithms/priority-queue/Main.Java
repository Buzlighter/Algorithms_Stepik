import java.util.*;

public  class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.valueOf(scanner.nextLine());
        ArrayList<String> commands = new ArrayList();
        for (int i = 0; i < n; i++) {
            commands.add(scanner.nextLine());
        }

        Heap heap = new Heap();

        for (String command: commands) {
            if (command.contains("Insert")) {
                String[] s = command.split(" ");
                heap.insert(Integer.valueOf(s[1]));
            }
            else if (command.contains("ExtractMax")) {
                System.out.println(heap.extractMax());
            }
        }
    }

    public static class Heap {
        private ArrayList<Integer> arrayList = new ArrayList<>();

        public Heap() {
            this.arrayList.add(null);
        }

        public void insert(Integer x) {
            arrayList.add(x);
            siftUp(arrayList.size()-1);
        }

        public int extractMax() {
            Integer maxElement = (Integer) arrayList.get(1);
            Collections.swap(arrayList, 1, arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            siftDown();
            return maxElement;
        }

        private void siftUp(Integer i) {
            while (i > 1 && arrayList.get(i) > arrayList.get(i/2)) {
                Collections.swap(arrayList,i, i/2);
                i /= 2;
            }
        }

        private void siftDown() {
            Integer i = 1;
            Integer j;
            while (2*i <= arrayList.size() - 1) {
                j = i;
                if (arrayList.get(2*i) > arrayList.get(j)) {
                    j = 2*i;
                }
                if ((2*i+1 <= arrayList.size() - 1) && (arrayList.get(2*i+1) > arrayList.get(j))) {
                    j = 2*i+1;
                }
                if (j == i) {
                    break;
                }
                Collections.swap(arrayList, i, j);
                i = j;
            }
        }
    }
}
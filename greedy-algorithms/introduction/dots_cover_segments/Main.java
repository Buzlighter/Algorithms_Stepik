import java.util.*;

public  class Main {
    public static void main(String[] args) {
        List <Integer> result = new ArrayList<>();
        Integer n, l = 0, r = 0, pairs = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        ArrayList <MyPair>  arraySegments = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            l = scan.nextInt();
            r = scan.nextInt();
            arraySegments.add(j,new MyPair(l, r));
        }
        Collections.sort(arraySegments, Collections.reverseOrder(Comparator.comparing(a -> a.getL())));

        for (MyPair pair:arraySegments) {
            if (result.isEmpty() || pair.getR() < result.get(result.size() - 1)) {
                result.add(pair.getL());
            }
        }

        System.out.println(result.size());
        for (Integer i:result) {
            System.out.println(i + " ");
        }
    }

    public static class MyPair<Integer> {
        private int l;
        private int r;

        public MyPair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public void setL(int l) {
            this.l = l;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getR() {
            return r;
        }

        public int getL() {
            return l;
        }

        @Override
        public String toString() {
            return "MyPair{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }
}
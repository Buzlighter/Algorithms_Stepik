import java.util.*;
public class Main {
    public static void main(String[] args) {
        Integer n, WBag, WItem, CItem;
        Double CBag = Double.valueOf(0), CUnit = Double.valueOf(0);
        List <MyPair> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        WBag = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            CItem = scanner.nextInt();
            WItem = scanner.nextInt();
            CUnit = (double)CItem/WItem;
            list.add(i, new MyPair(CUnit, WItem));
        }
        list.sort(Comparator.comparing(MyPair::getCUnit).reversed());

        for (MyPair elements: list) {
            if (WBag >= 1) {
                if (WBag > elements.getWItem()) {
                    CBag += (elements.getWItem()) * (elements.getCUnit());
                    WBag -= elements.getWItem();
                } else if (WBag <= elements.getWItem()) {
                    CBag += WBag * (elements.getCUnit());
                    WBag -= elements.getWItem();
                }
            }
        }
        System.out.println(CBag);

    }
    public static class MyPair {
        private int WItem;
        private double CUnit;
        MyPair(Double CUnit, Integer WItem)
        {
            this.WItem = WItem;
            this.CUnit = CUnit;
        }

        public void setWItem(int WItem) {
            this.WItem = WItem;
        }

        public void setCUnit(double CUnit) {
            this.CUnit = CUnit;
        }

        public int getWItem() {
            return WItem;
        }

        public double getCUnit() {
            return CUnit;
        }

    }

}
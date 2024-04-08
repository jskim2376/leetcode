import java.util.TreeSet;

class SmallestInfiniteSet {
    TreeSet<Integer> removedInteger;

    public SmallestInfiniteSet() {
        removedInteger = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            removedInteger.add(i);
        }
    }

    public int popSmallest() {
        int small = removedInteger.first();
        removedInteger.remove(small);
        return small;
    }

    public void addBack(int num) {
        removedInteger.add(num);
    }
}
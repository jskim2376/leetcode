import java.util.ArrayList;
import java.util.List;

class RecentCounter {
    List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);

        int result = 0;
        int left = t - 3000, right = t;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (left <= list.get(i) && list.get(i) <= right)
                result++;
            else
                break;
        }

        return result;
    }
}
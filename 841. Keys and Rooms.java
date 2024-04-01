import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> keys = new LinkedList<>();

        visited[0] = true;
        keys.addAll(rooms.getFirst());

        while (!keys.isEmpty()) {
            int key = keys.removeFirst();
            if (visited[key]) {
                continue;
            }

            visited[key] = true;
            keys.addAll(rooms.get(key));
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
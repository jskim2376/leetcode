class Solution {
    final int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // 4방향 이동

    public int orangesRotting(int[][] grid) {
        int minute = 0;

        int m = grid.length;
        int n = grid[0].length;
        int freshOrangeCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 신선한 오렌지 수를 세고, 썩은 오렌지의 위치를 큐에 추가
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    freshOrangeCount++;
                else if (grid[row][col] == 2)
                    queue.offer(new int[] { row, col });
            }
        }

        // 큐를 사용한 BFS로 썩은 오렌지로부터 인접한 신선한 오렌지를 썩게 함
        while (!queue.isEmpty() && freshOrangeCount > 0) {

            // 각 분은 큐의 사이즈로 구분
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();

                for (int[] direction : directions) {
                    int newRow = position[0] + direction[0];
                    int newCol = position[1] + direction[1];

                    // 인접한 신선한 오렌지를 찾아 썩게 하고 큐에 추가
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOrangeCount--;
                        queue.offer(new int[] { newRow, newCol });
                    }
                }
            }
            minute++;
        }

        return freshOrangeCount == 0 ? minute : -1;
    }
}

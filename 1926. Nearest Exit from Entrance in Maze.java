import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Position {
        int row;
        int col;
        int pathCount;

        Position(int row, int col, int pathCount) {
            this.row = row;
            this.col = col;
            this.pathCount = pathCount;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int shortestPathLength = Integer.MAX_VALUE;
        Position entracneP = new Position(entrance[0], entrance[1], -1);

        int rowLenght = maze.length;
        int colLength = maze[0].length;
        boolean[][] visited = new boolean[rowLenght][colLength];

        Queue<Position> queue = new LinkedList<>();
        queue.offer(entracneP);

        while (!queue.isEmpty()) {
            Position p = queue.poll();
            // 탈출 할 경우
            if (p.row == -1 || p.row == rowLenght || p.col == -1 || p.col == colLength) {
                if (p.pathCount != 0)
                    shortestPathLength = Math.min(shortestPathLength, p.pathCount);
                continue;
            }
            // 벽일 경우
            if (maze[p.row][p.col] == '+')
                continue;
            // 이미 방문했을 경우
            if (visited[p.row][p.col])
                continue;

            visited[p.row][p.col] = true;

            queue.offer(new Position(p.row - 1, p.col, p.pathCount + 1)); // up
            queue.offer(new Position(p.row + 1, p.col, p.pathCount + 1)); // down
            queue.offer(new Position(p.row, p.col + 1, p.pathCount + 1)); // left
            queue.offer(new Position(p.row, p.col - 1, p.pathCount + 1)); // right

        }
        return shortestPathLength != Integer.MAX_VALUE ? shortestPathLength : -1;
    }
}
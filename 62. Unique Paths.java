class Solution {
    private static final int INITIAL_PATH_COUNT = 1;
    private static final int NOT_CALCULATED = 0;

    public int uniquePaths(int m, int n) {
        int[][] pathCount = new int[m][n];
        pathCount[m - 1][n - 1] = INITIAL_PATH_COUNT;

        return calculatePaths(pathCount, m, n, 0, 0);
    }

    private int calculatePaths(int[][] pathCount, int m, int n, int row, int col) {
        // 이미 계산된 경로의 수가 있다면 반환
        if (pathCount[row][col] != NOT_CALCULATED) {
            return pathCount[row][col];
        }

        // 마지막 행이 아니라면, 아래쪽 경로 탐색
        if (row < m - 1) {
            pathCount[row][col] += calculatePaths(pathCount, m, n, row + 1, col);
        }

        // 마지막 열이 아니라면, 오른쪽 경로 탐색
        if (col < n - 1) {
            pathCount[row][col] += calculatePaths(pathCount, m, n, row, col + 1);
        }

        return pathCount[row][col];
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // 도시의 수
        boolean[] visited = new boolean[n]; // 도시의 방문 여부를 추적하는 배열

        int province = 0; // 도의 수
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않은 도시를 찾으면
                dfs(isConnected, visited, i); // DFS로 도의 모든 도시 방문
                province++; // 새로운 도 발견
            }
        }

        return province;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        int n = isConnected.length;
        visited[i] = true; // 현재 도시를 방문했음을 표시
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[i][j] == 1) { // 직접 연결된 아직 방문하지 않은 도시가 있는 경우
                dfs(isConnected, visited, j); // 연결된 다음 도시로 이동
            }
        }
    }
}

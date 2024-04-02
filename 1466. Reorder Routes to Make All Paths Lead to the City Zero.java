public class Solution {
    public int minReorder(int n, int[][] connections) {
        // 각 노드에서 출발하는 간선 리스트를 저장할 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 연결을 그래프에 추가
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[] { to, 1 }); // 방향성 있는 간선
            graph.get(to).add(new int[] { from, 0 }); // 방향성 없는 간선
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] edge : graph.get(node)) {
            if (!visited[edge[0]]) {
                count += edge[1]; // 방향성 있는 간선일 경우 카운트 증가
                count += dfs(edge[0], graph, visited);
            }
        }

        return count;
    }
}

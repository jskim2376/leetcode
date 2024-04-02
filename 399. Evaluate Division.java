public class Solution {
    static class Edge {
        String target;
        double weight;

        Edge(String target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구축
        Map<String, List<Edge>> graph = buildGraph(equations, values);

        // 쿼리 처리
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return results;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, value));
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, 1 / value));
        }
        return graph;
    }

    private double dfs(String src, String dest, Set<String> visited, Map<String, List<Edge>> graph) {
        if (!graph.containsKey(src))
            return -1.0;
        if (src.equals(dest))
            return 1.0;
        visited.add(src);

        for (Edge edge : graph.get(src)) {
            if (visited.contains(edge.target))
                continue;
            double pathValue = dfs(edge.target, dest, visited, graph);
            if (pathValue != -1.0) {
                return pathValue * edge.weight;
            }
        }

        return -1.0;
    }
}

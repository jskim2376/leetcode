class Solution {
    public long maxScore(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i){
            ess[i][0] = efficiency[i];
            ess[i][1] = speed[i];
        }
        
        Arrays.sort(ess, (a, b) -> -Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long score = 0, total = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            total += es[1];
            if (pq.size() > k) total -= pq.poll();
            if (pq.size() == k) score = Math.max(score, (total * es[0]));
        }
        return score;
    }
}
import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> firstQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> lastQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 초기 후보를 큐에 추가
        for (int i = 0; i < candidates; i++) {
            firstQueue.add(new int[] { costs[i], i });
        }
        for (int i = costs.length - candidates; i < costs.length; i++) {
            lastQueue.add(new int[] { costs[i], i });
        }

        long result = 0;
        int firstMaxIndex = candidates - 1; // 마지막으로 첫 큐에 추가된 요소의 인덱스
        int lastMinIndex = costs.length - candidates; // 마지막으로 끝 큐에 추가된 요소의 인덱스

        while (k-- > 0) {
            int[] first = firstQueue.peek();
            int[] last = lastQueue.peek();

            if (first[0] <= last[0]) {
                result += first[0];
                firstQueue.poll();
                // 첫 번째 큐에서 요소를 선택한 경우, 슬라이딩 윈도우를 오른쪽으로 확장
                if (firstMaxIndex + 1 < costs.length) {
                    firstQueue.add(new int[] { costs[++firstMaxIndex], firstMaxIndex });
                }
                if (!lastQueue.isEmpty() && lastQueue.peek()[1] == first[1]) {
                    lastQueue.poll();
                }
            } else {
                result += last[0];
                lastQueue.poll();
                // 마지막 큐에서 요소를 선택한 경우, 슬라이딩 윈도우를 왼쪽으로 확장
                if (lastMinIndex > 0) {
                    lastQueue.add(new int[] { costs[--lastMinIndex], lastMinIndex });
                }
                if (!firstQueue.isEmpty() && firstQueue.peek()[1] == last[1]) {
                    firstQueue.poll();
                }
            }
        }

        return result;
    }
}

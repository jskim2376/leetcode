class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = collections.Counter(nums)
        freqs_number = []
        for f in freqs:
            heapq.heappush(freqs_number, (-freqs[f], f))
        top_k = []
        for _ in range(k):
            top_k.append(heapq.heappop(freqs_number)[1])

        return top_k

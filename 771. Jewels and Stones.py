class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        hash = {}
        for stone in stones:
            if stone not in hash:
                hash[stone] = 1
            else:
                hash[stone] += 1
        result = 0
        for j in jewels:
            if j in hash:
                result += hash[j]

        return result

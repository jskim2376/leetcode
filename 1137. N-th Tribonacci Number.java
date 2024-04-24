class Solution {
    public int tribonacci(int n) {
        int[] table = new int[n + 3];

        table[0] = 0;
        table[1] = 1;
        table[2] = 1;

        // 반복문을 사용하고 있음!
        for (int t3 = 3; t3 <= n; t3++) {
            // Table을 채워나감!
            table[t3] = table[t3 - 3] + table[t3 - 2] + table[t3 - 1];
        }
        return table[n];
    }
}
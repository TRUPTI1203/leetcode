class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCount = new int[k];

        // Empty prefix sum has remainder 0
        remainderCount[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int remainder = prefixSum % k;

            // Handle negative remainders in Java
            if (remainder < 0) {
                remainder += k;
            }

            // Previous equal remainders form valid subarrays
            count += remainderCount[remainder];

            // Record the current remainder
            remainderCount[remainder]++;
        }

        return count;
    }
}
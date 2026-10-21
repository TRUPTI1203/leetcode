class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Calculate the sum of all elements
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Right sum = total sum - left sum - current element
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum for the next index
            leftSum += nums[i];
        }

        return -1;
    }
}
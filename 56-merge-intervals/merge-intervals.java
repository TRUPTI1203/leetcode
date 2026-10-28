class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Store merged intervals
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // If result is empty or intervals don't overlap
            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // Merge overlapping intervals
                result.get(result.size() - 1)[1] =
                    Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        // Step 3: Convert list to 2D array
        return result.toArray(new int[result.size()][]);
    }
}
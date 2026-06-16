class Solution {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = Integer.MIN_VALUE;
        ans = Math.max(robHouse(nums, 1, dp, nums.length), ans);
        Arrays.fill(dp, -1);
        ans = Math.max(ans, robHouse(nums, 0, dp, nums.length - 1));
        return ans;
    }
    private int robHouse(int[] A, int i, int[] dp, int n) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int inc = robHouse(A, i + 2, dp, n) + A[i];
        int exc = robHouse(A, i + 1, dp, n);

        return dp[i] = Math.max(inc, exc);
    }
}

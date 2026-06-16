class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHouse(nums, 0, dp);
    }

    private int robHouse(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];

        // rob
        int robbing = robHouse(nums, i + 2, dp) + nums[i];
        // not rob
        int notRobbing = robHouse(nums, i + 1, dp);

        return dp[i] = Math.max(robbing, notRobbing);
    }
}

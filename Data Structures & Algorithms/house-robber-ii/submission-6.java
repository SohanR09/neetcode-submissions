class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(getMax(Arrays.copyOfRange(nums, 1, n)), getMax(Arrays.copyOfRange(nums, 0, n - 1)));
    }
    public int getMax(int[] A) {

        int rob1 = 0, rob2 = 0;

        for (int a: A) {
            int curRob = Math.max(rob1 + a, rob2);
            rob1 = rob2;
            rob2 = curRob;
        }


        return rob2;
    }
}

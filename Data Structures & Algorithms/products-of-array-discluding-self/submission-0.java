class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Input: nums = [1,2,4,6]
        // produyct array = [48, 24, 12, 8]
        int n = nums.length;

        int[] preArr = new int[n];
        preArr[0] = 1;
        int[] sufArr = new int[n];
        sufArr[n-1] = 1;

        for (int i = 1; i < n; i++) {
            preArr[i] = nums[i-1] * preArr[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            sufArr[i] = nums[i+1] * sufArr[i+1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = preArr[i] * sufArr[i];
        }
        return res;
    }
}  

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int cur: nums){
            xor ^= cur;
        }
        return xor;
    }
}

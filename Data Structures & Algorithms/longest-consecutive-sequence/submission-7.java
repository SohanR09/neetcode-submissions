class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return 1;
        Set<Integer> numSet = new HashSet<>();
        for(int cur: nums){
            numSet.add(cur);
        }

        int n = nums.length;
        int isZero = 0;
        for(int cur: nums){
            if(cur == 0) isZero++;
        }
        if(isZero == n) return 1;

        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}

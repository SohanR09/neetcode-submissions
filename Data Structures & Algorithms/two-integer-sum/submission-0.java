class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashmap = new HashMap<>();

        // A[i] + A[j] = target;
        // A[j] = target - A[i];
        // x = target - curr;
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            int x = target - curr;
            if(!hashmap.containsKey(x)){
                hashmap.put(curr, i);
            }else{
                return new int[]{hashmap.get(x), i};
            }
        }
        return new int[2];
    }
}

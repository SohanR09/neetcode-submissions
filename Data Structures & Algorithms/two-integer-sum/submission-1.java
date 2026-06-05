class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // nums[j] = target - nums[i]
            if (!map.containsKey(target - cur)) {
                map.put(cur, i);
            } else {
                return new int[]{map.get(target - cur), i};
            }
        }

        return new int[]{-1, -1};
    }
}

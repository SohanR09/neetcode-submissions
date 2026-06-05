class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int cur: nums) {
            if (!set.contains(cur)) set.add(cur);
            else return true;
        }
        return false;
    }
}
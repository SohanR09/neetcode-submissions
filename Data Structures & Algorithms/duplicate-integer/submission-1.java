class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for(int curr: nums){
            if(hashset.contains(curr)) return true;
            else hashset.add(curr);
        }
        return false;
    }
}
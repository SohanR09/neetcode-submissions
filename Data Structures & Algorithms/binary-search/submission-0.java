class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e){
            int mid_idx = s + (e - s) / 2;
            int mid = nums[mid_idx];
            if(mid > target){
                e = mid_idx - 1;
            }else if(mid < target){
                s = mid_idx + 1;
            }else if(mid == target){
                return mid_idx;
            }
        }
        return -1;
    }
}

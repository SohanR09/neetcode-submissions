class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        return nums[pivot];
    }
    int findPivot(int[] A, int s, int e){
        while(s <= e){
            if(A[s] <= A[e]){
                return s;
            }
            int mid = s + (e - s) / 2;
            if(A[mid] > A[e]){
                s = mid + 1;
            }else e = mid;
        }
        return s;
    }
}

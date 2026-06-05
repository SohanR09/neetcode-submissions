class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] ==  target) return 0;
        
        int pivot =  findPivot(nums, 0, nums.length - 1);
        int result = 0;

        System.out.println(pivot);

        if(pivot == 0){
            return binarySearch(nums, 0, nums.length -1, target); 
        }else if(nums[pivot] == target){
            return pivot;
        }else if(nums[0] > target){
            return binarySearch(nums, pivot, nums.length - 1, target);
        }else if(nums[0] < target){
            return binarySearch(nums, 0, pivot - 1, target);
        }
        return -1;
    }
    private int binarySearch(int[] A, int s, int e, int target){
        while(s <= e){
            int mid = s + (e - s) / 2;
            if(A[mid] < target) s = mid + 1;
            else if(A[mid] > target) e = mid - 1;
            else return mid;
        }
        return -1;
    }
    private int findPivot(int[] A, int s, int e){
        int pivot = -1;

        while(s <= e){
            if(A[s] <= A[e]){
                return s;
            }
            int mid = s + (e-s)/2;

            if(A[mid] > A[e]){
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}

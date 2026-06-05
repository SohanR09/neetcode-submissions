class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int s = 0;
        int e = n * m - 1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] > target){
                e = mid - 1;
            }else if(matrix[row][col] < target){
                s = mid + 1;
            }else if(matrix[row][col] == target){
                return true;
            }
        }

        return false;
    }
}

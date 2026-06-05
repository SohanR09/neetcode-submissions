class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsn = findNextSmallest(heights);
        int[] psn = findPrevSmallest(heights);

        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int width = nsn[i] - psn[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
    private int[] findNextSmallest(int[] A){
        int n = A.length;

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int idx = n - 1;

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[idx] = stack.peek();
                idx--;
            }else {
                ans[idx] = n;
                idx--; 
            }
            stack.push(i);
        }
        return ans;
    }
    private int[] findPrevSmallest(int[] A){
        int n = A.length;

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int idx = 0;

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[idx] = stack.peek();
                idx++;
            }else{
                ans[idx] = -1;
                idx++;
            }
            stack.push(i);
        }

        return ans;
    }
}

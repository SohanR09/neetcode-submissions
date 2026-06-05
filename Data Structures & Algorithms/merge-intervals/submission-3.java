class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;

        ArrayList<int[]> ans = new ArrayList<>();
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];

        for(int i = 1; i < n; i++){
            int a2 = intervals[i][0];
            int b2 = intervals[i][1];

            if(a2 <= b1){
                a1 = Math.min(a1, a2);
                b1 = Math.max(b1, b2);
            }else if(b1 < a2){
                int[] temp = new int[2];
                temp[0] = a1;
                temp[1] = b1;
                ans.add(temp);
                a1 = a2;
                b1 = b2;
            }else if(b2 < a1){
                int[] temp = new int[2];
                temp[0] = a1;
                temp[1] = b1;
                ans.add(temp);
            }
        }
        int[] temp = new int[2];
        temp[0] = a1;
        temp[1] = b1;
        ans.add(temp);

        int[][] result = new int[ans.size()][2];
        int idx = 0;
        for(int i = 0; i < ans.size(); i++){
            result[idx] = ans.get(i);
            idx++;
        }
        return result;
    }
}

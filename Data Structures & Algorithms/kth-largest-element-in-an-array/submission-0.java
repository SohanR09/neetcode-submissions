class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 0) return -1;

        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int cur: nums) {
            pq.add(cur);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

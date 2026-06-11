class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int s: stones) {
            pq.add(s);
        }

        while (!pq.isEmpty()) {
            int x = pq.poll();

            if (pq.isEmpty()) return x;
            int y = pq.poll();

            if (x == y) continue;
            else if (x > y) {
                int z = x - y;
                pq.offer(z);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}

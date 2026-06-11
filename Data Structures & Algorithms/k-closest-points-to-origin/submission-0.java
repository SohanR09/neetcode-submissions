class Solution {
    private class Pair {
        int x, y;
        double dis;
        public Pair (int x, int y, double dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // if (points == null || points.length == 0 || k < 0) return ;

        int n = points.length, m = points[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));    

        for (int[] p: points) {
            int x = p[0], y = p[1];
            double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            pq.add(new Pair(x, y, dis));
            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            res[i][0] = cur.x;
            res[i][1] = cur.y;
            i++;
        }
        return res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int cur: nums) count.put(cur, count.getOrDefault(cur, 0) + 1);

        List<Integer>[] feq = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) feq[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            feq[entry.getValue()].add(entry.getKey());
        }

        System.out.println(Arrays.toString(feq));

        int[] res = new int[k];
        int j = 0;
        for (int i = feq.length - 1; i > 0 && j < k ; i--) {
            for (int n: feq[i]) {
                res[j++] = n;
                if (j == k) return res;
            }
        }
        return res;
    }
}

class Solution {
    private static class Pair {
        public int num;
        public int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        int[] ans = new int[k];

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().num;
        }

        return ans;
    }
}

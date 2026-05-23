class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (Integer s: stones) {
            pq.offer(s);
        }

        while (pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if (s1 > s2) {
                pq.offer(s1 - s2);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDist(b) - getDist(a));
        int[][] res = new int[k][2];

        for (int[] coord: points) {
            pq.offer(coord);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    private int getDist(int[] coord) {
        int x = coord[0];
        int y = coord[1];
        return x * x + y * y;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // row, col, effort

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if (effort > dist[r][c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + x[i];
                int nc = c + y[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newEffort = Math.max(
                        effort,
                        Math.abs(heights[r][c] - heights[nr][nc])
                    );

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}
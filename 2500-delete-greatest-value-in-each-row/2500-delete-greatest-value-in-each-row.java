class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer>[] pq = new PriorityQueue[m];

        for(int i = 0; i < m; i++){
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
            for(int j = 0; j < n; j++){
                pq[i].offer(grid[i][j]);
            }
        }

        while(pq[0].size() != 0){
            int max = 0;

            for(int i = 0; i < m; i++){
                int x = pq[i].poll();
                max = Math.max(max, x);
            }
            ans += max;
        }
        return ans;
    }
}
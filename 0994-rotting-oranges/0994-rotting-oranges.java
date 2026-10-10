class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    grid[i][j] = -2;
                } 

                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        while (!q.isEmpty() && fresh > 0){
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = p.row + row[d];
                    int nc = p.col + col[d];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1){
                        grid[nr][nc] = -2;
                        fresh--;
                        q.offer(new Pair(nr, nc));
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
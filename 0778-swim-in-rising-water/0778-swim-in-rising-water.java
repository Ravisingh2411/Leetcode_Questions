import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = grid[0][0];
        int high = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                high = Math.max(high, grid[i][j]);
            }
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (bfs(grid, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean bfs(int[][] grid, int time) {
        int n = grid.length;

        if (grid[0][0] > time) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n &&
                    !visited[nx][ny] &&
                    grid[nx][ny] <= time) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
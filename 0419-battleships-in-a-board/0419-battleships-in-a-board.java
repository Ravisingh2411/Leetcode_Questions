class Solution {

    private void dfs(int j, int k, boolean[][] vis, char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        vis[j][k] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = j + dRow[i];
            int newCol = k + dCol[i];

            if (newRow >= 0 && newRow < m &&
                newCol >= 0 && newCol < n &&
                arr[newRow][newCol] == 'X' &&
                !vis[newRow][newCol]) {

                vis[newRow][newCol] = true;
                dfs(newRow, newCol, vis, arr);
            }
        }
    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !vis[i][j]) {
                    dfs(i, j, vis, board);
                    count++;
                }
            }
        }

        return count;
    }
}
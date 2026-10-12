class Solution {

    boolean valid(int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }

    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};

    void dfs(char[][] board, int m, int n, int i, int j){

        board[i][j] = '#';
        for(int k = 0; k < 4; k++){
            int row = i+x[k];
            int col = j+y[k];

            if((valid(row, col, m, n)) && board[row][col] == 'O'){
                dfs(board, m, n, row, col);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int i, j;
        for(j = 0; j < n; j++){
            if(board[0][j] == 'O')
                dfs(board, m, n, 0, j);
        }

        for(j = 0; j < n; j++){
            if(board[m-1][j] == 'O')
                dfs(board, m, n, m-1, j);
        }

        for(i = 0; i < m; i++){
            if(board[i][0] == 'O')
                dfs(board, m, n, i, 0);
        }


        for(i = 0; i < m; i++){
            if(board[i][n-1] == 'O')
                dfs(board, m, n, i, n-1);
        }

        for(int l = 0; l < m; l++){
            for(int p = 0; p < n; p++){
                if(board[l][p] == '#') board[l][p] = 'O';
                else board[l][p] = 'X';
            }
        }
    }
}
class Cell implements Comparable<Cell> {
    int row;
    int col;

    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int compareTo(Cell other) {
        int d1 = row + col;
        int d2 = other.row + other.col;

        if(d1 != d2){
            return d1 - d2;
        }

        if(d1 % 2 == 0){
            return other.row - row;
        } 
        else{
            return row - other.row;
        }
    }
}
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                pq.add(new Cell(i, j));
            }
        }

        int[] ans = new int[m * n];
        int index = 0;

        while(!pq.isEmpty()){
            Cell curr = pq.poll();
            ans[index++] = mat[curr.row][curr.col];
        }
        return ans;
    }
}
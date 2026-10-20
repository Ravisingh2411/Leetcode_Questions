class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        int m = grid.length;
        int n = grid[0].length;

        int top = 0;
        int bottom = m-1;

        int row = -1;
        while(top <= bottom){
            int mid = (top+bottom)/2;

            if(target >= grid[mid][0] && target <= grid[mid][n-1]){
                row = mid;
                break;
            }
            if(grid[mid][0] > target) bottom = mid-1;
            if(grid[mid][0] < target) top = mid+1;
        }
        if(row == -1) return false;

        int l = 0;
        int h = n-1;

        while(l <= h){
            int mid = (l+h)/2;

            if(grid[row][mid] == target){
                return true;
            }
            if(grid[row][mid] > target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return false;
    }
}
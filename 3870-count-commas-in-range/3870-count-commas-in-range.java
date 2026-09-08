class Solution {
    public int countCommas(int n) {
        // if(n < 1000) return 0;
        // int count = 0;
        // int x = 1000;
        // while(x <= n){
        //     count++;
        //     x++;
        // }
        // return count;


        return Math.max(0, n - 999);
    }
}
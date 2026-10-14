class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";
        StringBuilder sb = new StringBuilder("");
        for(int j = 1; j <= num; j++){
            for(int i = 9; i >= 0; i--){
            if(i > sum) continue;
            else{
                sb.append(i); 
                sum -= i;
                break;
            }
            }
        }
        return sb.toString();
    }
}
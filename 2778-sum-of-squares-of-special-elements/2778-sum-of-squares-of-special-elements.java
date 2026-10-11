class Solution {
    public int sumOfSquares(int[] nums) {
        int j = 1;
        int sum = 0;
        int n = nums.length;
        for(int  i = 0; i < n; i++){
            if(n % j == 0){
                sum += nums[i]*nums[i];
            }
            j++;
        }
        return sum;
    }
}
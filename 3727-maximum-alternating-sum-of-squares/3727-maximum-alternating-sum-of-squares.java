class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);

        if(n % 2 == 0){
            for(int j = n-1; j >= (n/2); j--){
                sum += nums[j];
            }
            for(int k = (n/2)-1; k >= 0; k--){
                sum -= nums[k];
            }
        }
        else{
            for(int j = n-1; j >= (n/2); j--){
                sum += nums[j];
            }
            for(int k = (n/2)-1; k >= 0; k--){
                sum -= nums[k];
            }
        }
        return sum;
    }
}
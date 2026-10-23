class Solution {
    public int sortPermutation(int[] nums) {
        boolean sorted = true;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                sorted = false;
            }
        }

        if(sorted){
            return 0;
        }

        int[] correct = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            correct[i] = i;
        }

        int ans = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == correct[i]) continue;
            ans = ans & nums[i];
        }
        return ans;
    }
}
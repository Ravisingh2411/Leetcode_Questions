class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int m = 0, n = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                m = i;
            }
            if(max < nums[i]){
                max = nums[i];
                n = i;
            }
        }

        int m1 = Math.max(m, n) + 1;
        int m2 = nums.length - Math.min(m, n);
        int m3 = (Math.min(m, n) + 1) + (nums.length - Math.max(m, n));
        return Math.min(m1, Math.min(m2, m3));
    }
}
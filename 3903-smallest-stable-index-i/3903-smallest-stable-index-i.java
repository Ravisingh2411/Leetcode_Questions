class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxi = nums[0];

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
            int min = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
            }
            if (maxi - min <= k) {
                return i;
            }
        }
        return -1;
    }
}
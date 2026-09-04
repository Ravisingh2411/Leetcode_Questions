class Solution {
    // public int firstStableIndex(int[] nums, int k) {
    //     int n = nums.length;
    //     int maxi = nums[0];

    //     for (int i = 0; i < n; i++) {
    //         maxi = Math.max(maxi, nums[i]);
    //         int min = nums[i];
    //         for (int j = i; j < n; j++) {
    //             min = Math.min(min, nums[j]);
    //         }
    //         if (maxi - min <= k) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }


    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}
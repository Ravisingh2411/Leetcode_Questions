
class Solution {
    public int[] searchRange(int[] nums, int t) {
        int first = findFirst(nums, t);
        int last = findLast(nums, t);

        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int t) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == t) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int findLast(int[] nums, int t) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == t) {
                ans = mid;
                low = mid + 1; 
            } else if (nums[mid] < t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

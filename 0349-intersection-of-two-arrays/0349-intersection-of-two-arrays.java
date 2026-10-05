class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums1){
            set.add(ele);
        }

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for(int ele : nums2){
            if(set.remove(ele)){
                ans[k++] = ele;
            }
        }
        return Arrays.copyOf(ans, k);
    }
}
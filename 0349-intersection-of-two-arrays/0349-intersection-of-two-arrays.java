class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int ele : nums1) set.add(ele);

        // HashSet<Integer> s = new HashSet<>();
        // for(int ele : nums2) s.add(ele);

        // int[] ans = new int[Math.min(set.size(), s.size())];
        // int k = 0;

        // for(int ele : set){
        //     if(s.contains(ele)){
        //         ans[k++] = ele;
        //     }
        // }
        // return Arrays.copyOf(ans, k);



        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums1){
            set.add(ele);
        }

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for(int ele : nums2){
            if(set.contains(ele)){
                ans[k++] = ele;
                set.remove(ele); 
            }
        }
        return Arrays.copyOf(ans, k);
    }
}
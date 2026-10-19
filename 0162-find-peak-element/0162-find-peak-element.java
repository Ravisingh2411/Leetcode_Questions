class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            // int m = l + (r-l)/2;
            int m = l + (r-l+1)/2;

            // if(nums[m] > nums[m+1]){  //peak ele is either mid one or to it's left part
            //     r = m;
            // }
            // else l = m+1;


            if(nums[m] > nums[m-1]){  //peak ele is either mid one or to it's right part
                l = m;
            }
            else r = m-1;
        }
        return r;
        // return l;
    }
}
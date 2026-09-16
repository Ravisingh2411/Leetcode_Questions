class Solution {
    public int minimumOperations(int[] nums) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int x : nums) {
        //     if(x > 0){
        //         pq.add(x);
        //     }
        // }
        // int ans = 0;
        // while(!pq.isEmpty()){
        //     int ele = pq.peek();

        //     while (!pq.isEmpty()) {
        //         pq.remove();
        //     }

        //     ans++;
        //     for(int i = 0; i < nums.length; i++){
        //         if(nums[i] > 0){
        //             nums[i] = nums[i] - ele;

        //             if(nums[i] > 0){
        //                 pq.add(nums[i]);
        //             }
        //         }
        //     }
        // }
        // return ans;


        int ans = 0;
        while(true){
            int ele = Integer.MAX_VALUE;
            for(int x : nums){
                if(x > 0){
                    ele = Math.min(ele, x);
                }
            }
            if(ele == Integer.MAX_VALUE){
                break;
            }
            ans++;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    nums[i] -= ele;
                }
            }
        }
        return ans;


        // HashSet<Integer> set = new HashSet<>();
        // for(int x : nums){
        //     if(x > 0){
        //         set.add(x);
        //     }
        // }
        // return set.size();



    }
}
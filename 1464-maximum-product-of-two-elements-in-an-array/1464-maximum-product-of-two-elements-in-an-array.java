class Solution {
    public int maxProduct(int[] nums) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int x : nums){
        //     pq.add(x);
        // }
        // int q = pq.poll();
        // int r = pq.poll();
        // return (q-1)*(r-1);


        int max1 = 0, max2 = 0;
        for(int x : nums){
            if(x > max1){
                max2 = max1;
                max1 = x;
            }
            else if(x > max2){
                max2 = x;
            }
        }
        return (max1 - 1)*(max2 - 1);
    }
}
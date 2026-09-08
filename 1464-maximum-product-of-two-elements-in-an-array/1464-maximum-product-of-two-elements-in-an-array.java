class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : nums){
            pq.add(x);
        }
        int q = pq.poll();
        int r = pq.poll();
        return (q-1)*(r-1);
    }
}
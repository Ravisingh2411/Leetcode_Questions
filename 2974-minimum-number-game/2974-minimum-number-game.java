class Solution {
    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums) pq.add(x);
        int i = 0;
        while(pq.size() > 0){
            int alice = pq.poll();
            int bob = pq.poll();
            arr[i++] = bob;
            arr[i++] = alice;
        }
        return arr;
    }
}
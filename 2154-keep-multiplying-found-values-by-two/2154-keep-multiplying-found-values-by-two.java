class Solution {
    public int findFinalValue(int[] nums, int original) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for (int x : nums) {
        //     pq.add(x);
        // }
        // while (!pq.isEmpty()) {
        //     int x = pq.poll();
        //     if (x == original) {
        //         original *= 2;
        //     }
        //     else if (x > original) {
        //         break;
        //     }
        // }
        // return original;


        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
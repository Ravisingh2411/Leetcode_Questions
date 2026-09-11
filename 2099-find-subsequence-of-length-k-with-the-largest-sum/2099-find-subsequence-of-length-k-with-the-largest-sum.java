class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if(k == nums.length) return nums;
        int[] res = new int[k];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for(int i = 0; i < nums.length; i++){
            if(pq.size() < k) {
                pq.add(new int[]{nums[i], i});
            }
            else if(nums[i] > pq.peek()[0]) {
                pq.poll();
                pq.add(new int[]{nums[i], i});
            }
        }
        int[][] temp = new int[k][2];

        for(int i = 0; i < k; i++) {
            temp[i] = pq.poll();
        }

        Arrays.sort(temp, (a, b) -> a[1] - b[1]);
        for(int i = 0; i < k; i++) {
            res[i] = temp[i][0];
        }
        return res;
    }
}
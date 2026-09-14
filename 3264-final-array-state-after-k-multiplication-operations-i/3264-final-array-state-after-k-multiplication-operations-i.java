class Solution {
    class Pair implements Comparable<Pair>{
        int ele;
        int ind;

        Pair(int ele, int ind){
            this.ele = ele;
            this.ind = ind;
        } 

        public int compareTo(Pair other){
            if (this.ele != other.ele) {
                return Integer.compare(this.ele, other.ele);
            }
            return Integer.compare(this.ind, other.ind);
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(new Pair(nums[i], i));
        }
        while(k-- > 0){
            Pair p = pq.poll();
            int x = p.ele;
            int i = p.ind;
            pq.add(new Pair(x*multiplier, i));
            nums[i] = x*multiplier;
        }
        return nums;
    }
}
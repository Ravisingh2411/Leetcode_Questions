class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : stones){
            pq.add(w);
        }
        while(pq.size() > 1){
            int w1 = pq.poll();
            int w2 = pq.poll();
            if(w1 != w2){
                pq.add((w1-w2));
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
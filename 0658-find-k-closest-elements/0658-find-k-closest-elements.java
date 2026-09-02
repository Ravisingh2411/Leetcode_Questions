class Solution {
    class Pair implements Comparable<Pair>{
        int dist;
        int ele;

        Pair(int dist, int ele){
            this.dist = dist;
            this.ele = ele;
        }

        public int compareTo(Pair p){
            if(this.dist == p.dist) return p.ele - this.ele;
            return p.dist- this.dist;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int n : arr){
            int dist = Math.abs(n-x);
            if(pq.size() < k) pq.add(new Pair(dist, n));
            else{
               pq.add(new Pair(dist, n));
               pq.remove();
            }
        }
        while(pq.size() > 0){
            Pair top = pq.poll();
            ans.add(top.ele);
        }
        Collections.sort(ans);
        return ans;
    }
}
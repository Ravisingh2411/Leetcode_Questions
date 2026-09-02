class Solution {
    class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele, int freq){
        this.ele = ele;
        this.freq = freq;
    }
    public int compareTo(Pair p){
        if(this.freq == p.freq) return this.ele - p.ele;
        return this.freq - p.freq;
    }
}
    public int[] topKFrequent(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // minheap
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            if(pq.size() < k){
                pq.add(new Pair(ele,freq));
                continue;
            }
            if(freq < pq.peek().freq) continue;
            else{
                pq.remove();
                pq.add(new Pair(ele, freq));
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while(pq.size()>0){
            Pair top = pq.remove();
            ans[index++] = top.ele;
        }
        return ans;
    }
}
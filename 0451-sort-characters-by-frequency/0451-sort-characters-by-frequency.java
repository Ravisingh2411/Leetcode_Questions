class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        char c;

        Pair(int freq, char c){
            this.freq = freq;
            this.c = c;
        }

        public int compareTo(Pair other){
            if(this.freq != other.freq){
                return Integer.compare(other.freq, this.freq);
            }
            return this.c - other.c;
        }
    }
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char c : map.keySet()){
            pq.add(new Pair(map.get(c), c));
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i = 0; i < p.freq; i++){
                sb.append(p.c);
            }
        }
        return sb.toString();
    }
}
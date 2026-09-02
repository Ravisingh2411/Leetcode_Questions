class Solution {
    class Pair implements Comparable<Pair> {
        String word;
        int freq;
        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if (this.freq == p.freq) {
                return p.word.compareTo(this.word);
            }
            return this.freq - p.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (String s : map.keySet()) {
            int freq = map.get(s);
            if(pq.size() < k) pq.add(new Pair(s, freq));
            else{
                pq.add(new Pair(s, freq));
                pq.remove();
            }
        }
        while (pq.size() > 0) {
            Pair top = pq.remove();
            ans.add(0, top.word);
        }
        return ans;
    }
}
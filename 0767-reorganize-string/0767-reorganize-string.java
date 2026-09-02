class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }

        public int compareTo(Pair p) {
            if(this.freq == p.freq) return p.ch - this.ch;
            return p.freq - this.freq;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (char ch : map.keySet()) {
            pq.add(new Pair(map.get(ch), ch));
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Pair p1 = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != p1.ch){
                sb.append(p1.ch);
                p1.freq--;
                if(p1.freq > 0) pq.add(p1);
            }
            else{
                if(pq.size() == 0) return "";
                Pair p2 = pq.poll();
                sb.append(p2.ch);
                p2.freq--;
                if(p2.freq > 0) pq.add(p2);
                pq.add(p1);
            }
        }
        return sb.toString();
    }
}
class Solution {
    class Pair implements Comparable<Pair> {
        int freq;
        char c;

        Pair(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }

        public int compareTo(Pair other) {
            return Integer.compare(other.freq, this.freq);
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        if (a > 0) pq.add(new Pair(a, 'a'));
        if (b > 0) pq.add(new Pair(b, 'b'));
        if (c > 0) pq.add(new Pair(c, 'c'));

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            if (ans.length() >= 2 &&
                ans.charAt(ans.length() - 1) == p.c &&
                ans.charAt(ans.length() - 2) == p.c) {

                if (pq.isEmpty()) {
                    break;
                }

                Pair q = pq.poll();
                ans.append(q.c);
                q.freq--;

                if(q.freq > 0){
                    pq.add(q);
                }

                pq.add(p);
            } 
            else{
                ans.append(p.c);
                p.freq--;

                if(p.freq > 0){
                    pq.add(p);
                }
            }
        }
        return ans.toString();
    }
}
class Pair implements Comparable<Pair> {
    int freq;
    char a;

    Pair(int freq, char a) {
        this.freq = freq;
        this.a = a;
    }

    public int compareTo(Pair other) {
        return other.freq - this.freq;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> free = new HashMap<>();

        for (char a : tasks) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
            free.put(a, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.add(new Pair(e.getValue(), e.getKey()));
        }
        int seat = 1;

        while (!pq.isEmpty()) {
            ArrayList<Pair> pulled = new ArrayList<>();

            while (!pq.isEmpty()) {
                Pair p = pq.poll();

                if (free.get(p.a) <= seat) {
                    if (p.freq > 1) {
                        pq.add(new Pair(p.freq - 1, p.a));
                    }
                    free.put(p.a, seat + n + 1);
                    break;
                }
                else {
                    pulled.add(p);
                }
            }

            for (Pair p : pulled) {
                pq.add(p);
            }
            seat++;
        }
        return seat - 1;
    }
}
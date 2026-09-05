class Solution {
    class Pair implements Comparable<Pair> {
        int soldiers;
        int row;

        Pair(int soldiers, int row) {
            this.soldiers = soldiers;
            this.row = row;
        }

        public int compareTo(Pair other) {
            if (this.soldiers != other.soldiers) {
                return this.soldiers - other.soldiers;
            }
            return this.row - other.row;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++) {
                soldiers += mat[i][j];
            }
            pq.add(new Pair(soldiers, i));
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i] = p.row;
        }
        return ans;
    }
}
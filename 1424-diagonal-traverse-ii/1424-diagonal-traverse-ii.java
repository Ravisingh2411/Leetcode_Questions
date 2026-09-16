class Solution {
    class Triplet implements Comparable<Triplet>{
        int sum;
        int row;
        int val;

        Triplet(int sum, int row, int val){
            this.sum = sum;
            this.row = row;
            this.val = val;
        }
        
        public int compareTo(Triplet other){
            if(this.sum != other.sum){
                return Integer.compare(this.sum, other.sum);
            }
            return Integer.compare(other.row, this.row);
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        int total = 0;
        for(List<Integer> row : nums){
            total += row.size();
        }

        int[] res = new int[total];

        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums.get(i).size(); j++){
                pq.add(new Triplet(i+j, i, nums.get(i).get(j)));
            }
        }

        int i = 0;
        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            res[i++] = t.val;
        }
        return res;
    }
}
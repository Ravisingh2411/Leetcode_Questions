class Solution {
    class Pair implements Comparable<Pair>{
        int numerator;
        int denominator;

        Pair(int numerator, int denominator){
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int compareTo(Pair other){
            return Integer.compare(
                other.numerator * this.denominator,
                this.numerator * other.denominator
            );
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                Pair current = new Pair(arr[i], arr[j]);

                if(pq.size() < k){
                    pq.add(current);
                } 
                else{
                    Pair largest = pq.peek();
                    if(current.numerator * largest.denominator
                        < largest.numerator * current.denominator){
                        pq.poll();
                        pq.add(current);
                    }
                }
            }
        }

        Pair ans = pq.peek();
        return new int[]{ans.numerator,ans.denominator};
    }
}
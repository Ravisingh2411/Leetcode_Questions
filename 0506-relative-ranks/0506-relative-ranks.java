class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < score.length; i++){
            map.put(score[i], i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : score){
            pq.add(x);
        }

        int rank = 1;

        while(!pq.isEmpty()){
            int currentScore = pq.poll();
            int index = map.get(currentScore);

            if(rank == 1){
                ans[index] = "Gold Medal";
            }
            else if(rank == 2){
                ans[index] = "Silver Medal";
            }
            else if(rank == 3){
                ans[index] = "Bronze Medal";
            }
            else{
                ans[index] = String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
}
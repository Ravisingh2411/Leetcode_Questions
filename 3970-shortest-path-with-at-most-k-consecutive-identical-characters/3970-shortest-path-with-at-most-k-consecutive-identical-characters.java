class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new int[]{v, w});
        }

        long[][] dist = new long[n][k + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // {distance, node, consecutive count}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();

            long d = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            if(d > dist[node][count]){
                continue;
            }

            if(node == n - 1){
                return (int) d;
            }

            for(int[] next : adj.get(node)){
                int v = next[0];
                int wt = next[1];

                int newCount;

                if(labels.charAt(node) == labels.charAt(v)){
                    newCount = count + 1;
                } 
                else{
                    newCount = 1;
                }

                if(newCount > k){
                    continue;
                }

                long newDist = dist[node][count] + wt;

                if(newDist < dist[v][newCount]){

                    dist[v][newCount] = newDist;

                    pq.offer(new long[]{
                        newDist, v, newCount
                    });
                }
            }
        }
        return -1;
    }
}

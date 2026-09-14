class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double [] distance = new double[n];
        Arrays.fill(distance, -1);

        distance[start_node] = 1;

        for(int i = 0 ; i < n-1 ; i++){
            boolean updated = false;
            for(int j = 0 ; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                double w = succProb[j];

                if(distance[u] != -1 && distance[u]*w > distance[v]){
                    distance[v] = distance[u]*w;
                    updated = true;
                }

                if(distance[v] != -1 && distance[v]*w > distance[u]){
                    distance[u] = distance[v]*w;
                    updated = true;
                }
            }
            if(!updated) break;
        }

        return distance[end_node] == -1 ? 0 : distance[end_node];
    }
}

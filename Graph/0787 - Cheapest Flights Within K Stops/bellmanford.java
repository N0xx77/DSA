class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] distance = new int[n];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i = 0 ; i <= k ; i++){
            int [] temp = Arrays.copyOf(distance, n);
            for(int [] f : flights){
                int u = f[0];
                int v = f[1];
                int w = f[2];

                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < temp[v]){
                    temp[v] = distance[u] + w;
                }
            }
            distance = temp;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst]; 
    }
}

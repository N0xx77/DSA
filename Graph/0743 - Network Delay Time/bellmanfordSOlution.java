class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        for(int i = 1 ; i < n; i++){
            for(int [] e : times){
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                    distance[v] = distance[u]+w;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1 ; i<distance.length ; i++){
            System.out.println(distance[i]);
            if(distance[i] == Integer.MAX_VALUE) return -1;
            if(max < distance[i]){
                max = distance[i];
            }
        }

        return max;
    }
}

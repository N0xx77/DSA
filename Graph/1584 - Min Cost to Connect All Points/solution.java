class Solution {

    private int minKey(boolean [] mst, int [] key){
        int minValue = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i = 0 ; i < mst.length ; i++){
            if(!mst[i] && key[i] < minValue){
                minValue = key[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    private int prims(ArrayList<ArrayList<int []>> graph){
        int n = graph.size();
        int [] key = new int[n];
        boolean [] mst = new boolean[n];
        
        Arrays.fill(key, Integer.MAX_VALUE);

        int sum = 0;
        key[0] = 0;

        for(int i = 0 ; i < n ; i++){
            int u = minKey(mst, key);

            if(u == -1) return sum;

            mst[u] = true;

            for(int j = 0 ; j < graph.get(u).size() ; j++){
                int v = graph.get(u).get(j)[0];
                int w = graph.get(u).get(j)[1];

                if(!mst[v] && w < key[v]){
                    key[v] = w;
                }
            }
        }

        for(int i : key){
            sum+= i;
        }
        return sum;
    }


    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<int []>> graph = new ArrayList<>();

        for(int i = 0; i < points.length ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int x = points[i][0];
                int y = points[i][1];
                int u = points[j][0];
                int v = points[j][1];
                int distance = Math.abs(x-u) + Math.abs(y-v);
                graph.get(i).add(new int [] {j, distance});
                graph.get(j).add(new int[] {i, distance});
            }
        }

        
        int res = prims(graph);

        return res;

    }
}

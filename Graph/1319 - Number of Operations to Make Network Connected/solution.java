class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        int [] parents = new int[n];
        int components = n;

        for(int i = 0 ; i < n ; i++) parents[i] = i;

        for(int [] e: connections){
            int u = e[0];
            int v = e[1];
            int pu = findParent(parents, u);
            int pv = findParent(parents, v);

            if(pu != pv){
                parents[pu] = pv;
                components--;
            }
        }
        
        return components-1;
    }

    private int findParent(int [] parent, int i){
        if(parent[i] != i ){
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }
}

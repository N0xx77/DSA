class Solution {
    private int findParent(int [] parent, int i){
        if(parent[i] != i){
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<int []> res = new ArrayList<>();
        int n = edges.length;
        int [] parent = new int [n+1];

        for(int i = 0 ; i<= n ; i++) parent[i] = i;

        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            int pu = findParent(parent, u);
            int pv = findParent(parent, v);
            
            if(pu != pv){
                parent[pu] = pv;
            }
            else return e;
        }

        return new int[0];
    }
}

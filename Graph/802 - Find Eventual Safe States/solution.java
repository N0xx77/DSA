class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int [] state = new int[n];
        Arrays.fill(state, 0);

        for(int i = 0; i < n ; i++){
            if(dfs(graph, state, i)) res.add(i);
        }


        return res;
    }

    private boolean dfs(int [][] graph, int [] state, int idx){
        if(state[idx] != 0){
            return state[idx] == 2;
        }
        state[idx] = 1;
        for(int i : graph[idx]){
            if(!dfs(graph, state, i)) return false;
        }
        state[idx] = 2;
        return true;
    }
}

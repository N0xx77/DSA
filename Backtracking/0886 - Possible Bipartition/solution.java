class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer> [] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] e : dislikes){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Integer[] colours = new Integer[N+1];

        for(int i = 1 ; i <= N ; i++){
            if(colours[i] == null && !dfs(graph, colours, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(List<Integer> [] graph, Integer [] colours, int curr, int currColour){
        colours[curr] = currColour;

        for(Integer neighbours : graph[curr]){
            if(colours[neighbours] == null){
                if(!dfs(graph, colours, neighbours, currColour*-1)) return false;
            }
            else if(colours[neighbours] == currColour){
                return false;
            }
        }
        return true;
    }
    
}

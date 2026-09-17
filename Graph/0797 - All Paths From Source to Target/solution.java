class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backtrack(graph, res, temp, 0, graph.length);
        return res;
    }

    private void backtrack(int [][] graph, List<List<Integer>> res, List<Integer> temp, int index, int n){
        if(index == n-1) {
            res.add(new ArrayList<>(temp));
            return;
        }
    
        for(int node : graph[index]){
            temp.add(node);
            backtrack(graph, res, temp, node, n);
            temp.remove(temp.size()-1);
        }
    }
}

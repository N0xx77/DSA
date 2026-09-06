class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int index, int n, int k){
        if(k == 0) res.add(new ArrayList<>(temp));

        for(int i = index ; i <= n ; i++){
            temp.add(i);
            backtrack(res, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
}

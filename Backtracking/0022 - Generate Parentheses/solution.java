class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new String(), n, 0, 0);
        return res;

    }

    void backtrack(List<String> res, String temp, int n, int idx1, int idx2){
        if(temp.length() == n*2) {
            res.add(temp);
        }

            if(idx1 < n){
                backtrack(res, temp+"(", n, idx1+1, idx2);
            }
            if(idx2 < idx1){
                backtrack(res,temp+")", n, idx1, idx2+1);
            }

    }
}

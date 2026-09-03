class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, s.toCharArray());
        return ans;
    }

    private void backtrack(List<String> ans, int i, char [] S){
        if(i == S.length) ans.add(new String(S));
        else{
            if(Character.isDigit(S[i])){
                backtrack(ans, i+1, S);
            }
            else{
                S[i] = Character.toUpperCase(S[i]);
                backtrack(ans, i+1, S);
                S[i] = Character.toLowerCase(S[i]);
                backtrack(ans, i+1, S);
            }
        }
    }
}

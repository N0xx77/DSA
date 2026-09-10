class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> temp, int index, String s){
        if(index == s.length()) res.add(new ArrayList<>(temp));

        for(int i = index ; i < s.length() ; i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                backtrack(res, temp, i+1, s);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}

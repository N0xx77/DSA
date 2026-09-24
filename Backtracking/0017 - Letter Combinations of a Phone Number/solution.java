class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
       
        backtrack(res, new String(), digits, map, 0);
        return res;
    }

    void backtrack(List<String> res, String temp, String digits, HashMap<Character, String> map, int idx){
        if(temp.length() == digits.length()) res.add(temp);
        if(idx >= digits.length()) return;

        char num = digits.charAt(idx);
        String mapped = map.get(num);

        for(int i = 0 ; i < mapped.length() ; i++){
            backtrack(res, temp+mapped.charAt(i), digits, map, idx+1);
        }
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) return res;

        backtrack(res, new StringBuilder(), s, 0, 0, new StringBuilder());
        return res;
    }

    void backtrack(List<String> res, StringBuilder temp, String s, int dots, int index, StringBuilder sb){
        if(dots > 4) return;
        if(dots == 4 && index == s.length()) {
            res.add(temp.toString());
            return;
        }

        for(int i = index; i < s.length() ; i++){
            sb.append(s.charAt(i));
            if(sb.length() > 1 && sb.charAt(0) == '0') break;

            int num = Integer.parseInt(sb.toString());

            if(num > 255) break;
            
            temp.append(sb.toString());
            if(dots < 3){
                temp.append('.');
                backtrack(res, temp, s, dots+1, i+1, new StringBuilder());
                temp.delete(temp.length()-sb.length()-1, temp.length());
            }
            else{
                backtrack(res, temp, s, dots+1, i+1, new StringBuilder());
                temp.delete(temp.length()-sb.length(), temp.length());
            } 
        }
    }
}

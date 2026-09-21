class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> st = new Stack<>();
        String str = "";
        s = s.toLowerCase();


        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(c);
                str += c;
            }
        }

        for(int i = 0 ; i < str.length()/2 ; i++){
            char c = str.charAt(i);
            if(st.peek() == c){
                st.pop();
            }
            else return false;
        }

        return true;
    }
}

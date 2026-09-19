class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && map.get(c) == st.peek()){
                st.pop();
            }
            else{
                st.push(c);
            }
        }

        return st.size() > 0 ? false : true;
    }
}

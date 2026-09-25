class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < tokens.length ; i++){
            String s = tokens[i];

            if(s.length() == 1 && s.charAt(0) < '0' || s.charAt(0) > '9'){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(calculate(num1, num2, s.charAt(0)));
            }
            else{
                st.push(Integer.parseInt(s));
            }
            
        }

        return st.pop();
    }

    int calculate(int x, int y, char operator){
        if(operator == '-') return x-y;
        else if(operator == '*') return x*y;
        else if(operator == '/') return x/y;
        return x+y;
    }
}

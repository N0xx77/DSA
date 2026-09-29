class Solution {
    public void reverseString(char[] s) {
        int x = 0;
        int y = s.length -1;

        for(int i = 0 ; i< s.length/2 ; i++){
            char temp = s[x];
            s[x] = s[y];
            s[y] = temp;
            x++;
            y--;
        }
    }
}

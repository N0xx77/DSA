class Solution {
    public int climbStairs(int n) {
        if(n == 1) return n;
        int steps = 0;
        int prev = 0;

        for(int i = 1 ; i<=n ; i++){
            if(i == 1){
                steps = 1;
            }
            else if(i == 2){
                steps = 2;
                prev = 1;
            }
            else{
                int temp = steps;
                steps += prev;
                prev = temp;
            }
        }

        return steps;
    }
}

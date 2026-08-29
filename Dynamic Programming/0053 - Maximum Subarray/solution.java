class Solution {
    public int maxSubArray(int[] nums) {
        int dp [] = new int[nums.length];
        int prevSum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            dp[i] = Math.max(prevSum+curr, curr);
            prevSum = dp[i];
        }

        for(int i : dp){
            max = Math.max(max, i);
        }
        return max;
    }
}

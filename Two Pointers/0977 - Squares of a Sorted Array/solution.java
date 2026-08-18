class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] squares = new int [nums.length];
        int n = nums.length;
        int i = 0, j = n-1;

        for(int k = n-1 ; k >= 0 ; k--){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                squares[k] = nums[i]*nums[i];
                i++;
            }
            else {
                squares[k] = nums[j]*nums[j];
                j--;
            }
        }
        return squares;
    }
}

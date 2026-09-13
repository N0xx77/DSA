class Solution {
    public int removeElement(int[] nums, int val) {
       int left = 0;
       int right = nums.length-1;

       while(left <= right){
        if(nums[right] == val) right--;
        else if(nums[left] == val){
            nums[left] = nums[right];
            nums[right] = val;
            left++;
        }
        else{
            left++;
        }
       }

       return left;
    }
}

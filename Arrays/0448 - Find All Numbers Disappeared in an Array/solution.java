class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        while(i<n){
            int correct_position = nums[i] - 1;
            if(nums[correct_position] != nums[i]){
                int temp = nums[correct_position];
                nums[correct_position] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }

        for(i = 0 ; i < n ; i++){
            if(i+1 != nums[i]){
                res.add(i+1);
            }
        }

        return res;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int z = nums[i];
            int x = i+1, y = nums.length - 1;
            
            while(x < y){
                int currentSum = nums[x]+nums[y]+z;
                if(currentSum == 0){
                    res.add(Arrays.asList(z, nums[x], nums[y]));
                    x++;
                    while(x < y && nums[x] == nums[x-1]){
                        x++;
                    }
                }
                else if(currentSum > 0) y--;
                else x++;
            }
        }

        return res;
    }
}

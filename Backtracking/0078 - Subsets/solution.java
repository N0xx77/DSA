class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;

    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int i, int[] nums){
        ans.add(new ArrayList<>(temp));
        for(int j = i ; j< nums.length ; j++){
            temp.add(nums[j]);
            backtrack(ans, temp, j+1, nums);
            temp.remove(temp.size()-1);
        }
    }
    
}

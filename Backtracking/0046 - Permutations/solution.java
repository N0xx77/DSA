class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int [] nums, boolean [] used){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    
}

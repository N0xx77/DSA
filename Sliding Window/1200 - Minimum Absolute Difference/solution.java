class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i = 1 ; i < arr.length ; i++){
            int currDiff = Math.abs(arr[i] - arr[i-1]);
            minDiff = Math.min(minDiff, currDiff);
        }

        for(int i = 1 ; i < arr.length ; i++){
            int currDiff = Math.abs(arr[i] - arr[i-1]);
            if(currDiff == minDiff){
                res.add(List.of(arr[i-1], arr[i]));
            }
        }

        return res;
    }
}

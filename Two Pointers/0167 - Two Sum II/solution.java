class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];

        int i = 0, j = numbers.length - 1;

        for(int k = 0 ; k < numbers.length ; k++){
            if(numbers[i]+numbers[j] == target){
                res[0] = i+1;
                res[1] = j+1;
            }
            else if(numbers[i] + numbers[j] > target){
                j--;
            }
            else if(numbers[i] + numbers[j] < target){
                i++;
            }
        }

        return res;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int min = nums.length/2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, 1);
            }
            else map.put(n, map.get(n)+1);
        }

        int instances = 0;
        int key = 0;

        for(int k : map.keySet()){
            if(instances < map.get(k)){
                instances = map.get(k);
                key = k;
            }
        }

        return key;
    }
}

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        int total = 0;
        for(char c : jewels.toCharArray()){
            map.put(c, 0);
        }

        for(char c : stones.toCharArray()){
            if(map.containsKey(c)){
                total++;
            }
        }
        return total;
    }
}

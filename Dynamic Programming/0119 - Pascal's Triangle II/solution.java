class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal = new ArrayList<>();
        pascal.add(1);
        for(int i = 1 ; i <= rowIndex ; i++){
            for(int j = i-1 ; j >= 1 ; j--){
                pascal.set(j, pascal.get(j)+pascal.get(j-1));
            }
            pascal.add(1);

        }
        return pascal;
    }
}

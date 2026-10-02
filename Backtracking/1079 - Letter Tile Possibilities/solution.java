class Solution {
        int count;
    public int numTilePossibilities(String tiles) {
        count = 0;
        char [] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean [] visited = new boolean[chars.length];
        backtrack(chars, visited, 0);
        return count;

    }

    private void backtrack(char [] chars, boolean [] visited, int len){
        if(len == chars.length) return;
        
        for(int i = 0 ; i < chars.length ; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && chars[i] == chars[i-1] && !visited[i-1]) continue;
            count += 1;
            visited[i] = true;
            backtrack(chars, visited, len+1);
            visited[i] = false;
        }
    }
}

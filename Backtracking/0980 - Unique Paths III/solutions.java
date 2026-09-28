class Solution {
    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int empty = 0;
        int x = 0, y = 0;

        for(int i = 0 ; i< r ; i++){
            for(int j = 0 ; j< c; j++){
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                else if(grid[i][j] == 0) empty++;
            }
        }
        System.out.println(empty);

        return backtrack(grid, x, y, empty);

    }

    private int backtrack(int [][] grid, int x, int y, int zeroes){
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == -1) return 0;
        if(grid[x][y] == 2) return zeroes == 0 ? 1 : 0;
        
        if(grid[x][y] == 0) zeroes--; 
        grid[x][y] = -1;
        int total = backtrack(grid, x+1, y, zeroes) + backtrack(grid, x, y+1, zeroes)+ backtrack(grid, x-1, y, zeroes) + backtrack(grid, x, y-1, zeroes);

        zeroes++;
        grid[x][y] = 0;
        
        return total;
        
    }
}

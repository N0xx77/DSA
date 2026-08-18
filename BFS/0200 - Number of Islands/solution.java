class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int islands = 0;
        Queue<int []> q = new ArrayDeque<>();

        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    grid[i][j] = '2';
                    q.add(new int[] {i, j});
                    while(!q.isEmpty()){
                        int [] cords = q.poll();
                        int x = cords[0];
                        int y = cords[1];

                        if(x+1 < grid.length && grid[x+1][y] == '1'){
                            grid[x+1][y] = '2';
                            q.add(new int[] {x+1, y});
                        }
                        if(y+1 < grid[0].length && grid[x][y+1] == '1'){
                            grid[x][y+1] = '2';
                            q.add(new int[] {x, y+1});
                        }
                        if(x-1 >= 0 && grid[x-1][y] == '1'){
                            grid[x-1][y] = '2';
                            q.add(new int[] {x-1, y});
                        }
                        if(y-1 >= 0 && grid[x][y-1] == '1'){
                            grid[x][y-1] = '2';
                            q.add(new int[] {x, y-1});
                        }
                    }
                }
            }
        }
        return islands;
    }
}

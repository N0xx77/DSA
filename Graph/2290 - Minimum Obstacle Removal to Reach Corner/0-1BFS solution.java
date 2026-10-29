class Solution {
    private int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int distance [][] = new int[r][c];
        for(int i = 0 ; i< r ; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        if(grid[0][0] == 1) distance[0][0] = 1;
        else distance[0][0] = 0;

        Deque<int []> pq = new ArrayDeque<>();
        pq.add(new int [] {0, 0});

        while(!pq.isEmpty()){
            int [] cords = pq.poll();
            int x = cords[0];
            int y = cords[1];

            if(x == r-1 && y == c-1){
                return distance[x][y];
            }

            for(int [] d : dirs){
                int newX = x+d[0];
                int newY = y+d[1];

                if(newX >= 0 && newX < r && newY >= 0 && newY < c){
                    int w = grid[newX][newY];
                    if(distance[x][y] + w < distance[newX][newY]){
                        distance[newX][newY] = distance[x][y] + w;

                        if(w == 0) pq.addFirst(new int [] {newX, newY});
                        else pq.addLast(new int [] {newX, newY});
                    }
                }
            }
        }

        return distance[r-1][c-1];
    }
}

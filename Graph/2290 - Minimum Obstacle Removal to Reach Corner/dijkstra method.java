class Solution {
    private int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int distance [][] = new int[r][c];
        for(int i = 0 ; i< r ; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int []>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        distance[0][0] = 0;
        pq.offer(new int [] {grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            if(x == r-1 && y == c-1){
                return cost;
            }

            for(int [] d : dirs){
                int newX = x+d[0];
                int newY = y + d[1];

                if(newX >= 0 && newY >= 0 && newX < r && newY < c && cost + grid[newX][newY] < distance[newX][newY]){
                    distance[newX][newY] = cost + grid[newX][newY];
                    pq.offer(new int [] {distance[newX][newY], newX, newY});
                }
            }
        }
        return distance[r-1][c-1];
    }
}

class Solution {
    private int [][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int [][] time = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        time[0][0] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int [] {time[0][0], 0, 0, 1});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];
            int stepCost = curr[3];

            if(x == n-1 && y == m-1) return cost;

            for(int [] d : dirs){
                int newX = x+d[0];
                int newY = y + d[1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m){
                    int waitTime = Math.max(moveTime[newX][newY] - cost, 0);
                    int newAt = cost + stepCost+ waitTime;
                    
                    if(newAt < time[newX][newY]){
                        time[newX][newY] = newAt;
                        int newStepCost = (stepCost == 2) ? 1 : 2;
                        pq.offer(new int [] {newAt, newX, newY, newStepCost});
                    }
                }
            }
        }

        return -1;
    }
}

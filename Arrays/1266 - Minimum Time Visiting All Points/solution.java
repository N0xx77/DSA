class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int prevX = points[0][0];
        int prevY = points[0][1];

        for(int i = 1 ; i< points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];

            time += Math.max(Math.abs(x - prevX), Math.abs(y - prevY));
            prevX = x;
            prevY = y;
        }

        return time;
    }
}

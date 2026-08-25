class Solution {
    public int findMinArrowShots(int[][] points) {
        int res = 1;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int x = points[0][1];

        for(int i = 1 ; i< points.length ; i++){
            if(points[i][0] > x){
                x = points[i][1];
                res += 1;
            }
        }

        return res;
    }
}

//Intial logic:
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int [n][m];

        dp[0][0] = grid[0][0];

        for(int i = 0 ; i< n ; i++){
            if(i > 0){
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for(int j = 0 ; j<m ; j++){
                if(i == 0 && j > 0){
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                }
                else if(i > 0 && j > 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n-1][m-1];
    }
}

//Improved:
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] dp = new int [m];

        dp[0] = grid[0][0];

        for(int i = 1; i < m ; i++){
            dp[i] = grid[0][i] + dp[i-1];
        }

        for(int i = 1 ; i< n ; i++){
            dp[0] += grid[i][0];
            for(int j = 1 ; j<m ; j++){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }

        return dp[m-1];
    }
}

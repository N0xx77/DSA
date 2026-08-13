class Solution {
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int profit = 0;

        for(int p : prices){
            int temp = p - minCost;
            if(profit < temp) profit = temp;
            else if(minCost > p){
                minCost = p;
            }
        }

        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;


        int minCP=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            profit=Math.max(profit,prices[i]-minCP);
            minCP=Math.min(minCP,prices[i]);
        }

        return profit;
    }
}

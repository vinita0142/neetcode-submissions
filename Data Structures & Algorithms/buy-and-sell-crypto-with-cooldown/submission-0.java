class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int[][] dp=new int[n+2][2];


        for(int i=n-1;i>=0;i--){
            //can buy=1

            int buy=-prices[i]+dp[i+1][0];
            int skip=dp[i+1][1];

            dp[i][1]=Math.max(buy,skip);
            //cannot buy -> so sell or hold = 0
            int sell=prices[i]+dp[i+2][1];
            int hold=dp[i+1][0];
            dp[i][0]=Math.max(hold,sell);
        }

        return dp[0][1];
    }
}

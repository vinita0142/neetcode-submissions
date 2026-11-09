class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        

        int n=nums.length;
        int sum=0;

        for(int num:nums){
            sum+=num;
        }

        int offset=sum;
        if(target<-sum || target>sum) return 0;
        int[][] dp = new int[n + 1][2 * sum + 1];

        dp[n][target+offset]=1;


        for(int i=n-1;i>=0;i--){
            for(int csum=-sum;csum<=sum;csum++){
                int plus=0;
                int minus=0;

                if(csum+nums[i]<=sum){
                    plus=dp[i+1][csum+nums[i]+offset];
                }

                if(csum-nums[i]>=-sum){
                    minus=dp[i+1][csum-nums[i]+offset];
                }

                dp[i][csum+offset]=plus+minus;
            }
        }
        return dp[0][offset];
    }
}

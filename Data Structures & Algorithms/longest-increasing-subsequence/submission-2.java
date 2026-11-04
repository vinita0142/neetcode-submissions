class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev_index=i-1;prev_index>=-1;prev_index--){
                int take=0;

                if(prev_index==-1 || nums[i]>nums[prev_index]){
                    take=1+dp[i+1][i+1];
                }
                int skip=dp[i+1][prev_index+1];

                dp[i][prev_index+1]=Math.max(take,skip);
            }
        }

        return dp[0][0];
    }
}

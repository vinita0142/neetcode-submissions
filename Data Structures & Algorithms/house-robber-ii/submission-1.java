class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1) return nums[0];

        int case1 = robLinear(nums,0,n-2);
        int case2 = robLinear(nums,1,n-1);

        return Math.max(case1,case2);
    }


    private int robLinear(int[] nums,int start,int end){


        int dp[]=new int[nums.length];
        dp[start]=nums[start];
        
        if (start+1<=end){
            dp[start+1]=Math.max(nums[start],nums[start+1]);
        }

        for(int i=start+2;i<=end;i++){
            int take=nums[i]+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(take,skip);
        }

        return dp[end];
    }
}

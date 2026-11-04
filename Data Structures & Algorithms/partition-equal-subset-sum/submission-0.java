class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }

        if(totalSum%2==1) return false;

        int target=totalSum/2;

        int n=nums.length;

        boolean dp[][]=new boolean[n+1][target+1];

        for(int i=0;i<=n;i++){
            dp[i][target]=true;
        }

        for(int index=n-1;index>=0;index--){
            for(int csum=target-1;csum>=0;csum--){
                boolean take=false;

                if(csum+nums[index]<=target){
                    take=dp[index+1][csum+nums[index]];
                }
                boolean skip=dp[index+1][csum];
                dp[index][csum]=take||skip;
            }
        }


        return dp[0][0];
    }

    private boolean solve(int[] nums, int i,int csum,int target){
        if(csum==target) return true;
        if(csum>target) return false;

        if(i==nums.length) return false;


        boolean take=solve(nums,i+1,csum+nums[i],target);
        boolean skip=solve(nums,i+1,csum,target);

        return take || skip;
    }
}

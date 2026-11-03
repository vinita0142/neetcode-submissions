class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[0]*(n+2)

        for i in range(n-1,-1,-1):
            rob=nums[i]+dp[i+2]
            dont_rob=dp[i+1]
            dp[i]=max(rob,dont_rob)

        return dp[0]
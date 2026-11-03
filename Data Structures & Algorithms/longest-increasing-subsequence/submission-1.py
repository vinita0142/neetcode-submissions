class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[1]*n
        #dp[i] longest increasing subsequence ending at i 

        #so go through all i: now all possible subsequence till i would be in raneg j to i, so for every no check nums[j]<nums[i] i.e increasing order then update dp[i]=max(dp[i],1+dp[j])
        
        for i in range(n):
            for j in range(i):
                if nums[j]<nums[i]:
                    dp[i]=max(dp[i],dp[j]+1)

        return max(dp)


        
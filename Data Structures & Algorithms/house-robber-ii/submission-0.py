class Solution:
    def rob(self, nums: List[int]) -> int:
        #reduces to two cases 

        #if you rob last house you have to start at 1 
        #so range is 1, n-1

        #if you dont rob last house you can start at 0 and go till n-2
        #so range is 0,n-2

        n=len(nums)
        if n==1:
            return nums[0]

        def rob_range(start,end):
            dp=[0]*(n+2)
            for i in range(end,start-1,-1):
                rob=nums[i]+dp[i+2]
                dont_rob=dp[i+1]
                dp[i]=max(rob,dont_rob)
            return dp[start]


        case1=rob_range(0,n-2)
        case2=rob_range(1,n-1)
        return max(case1,case2)

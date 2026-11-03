class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n=len(nums)

        prefix=1
        suffix=1

        ans=float("-inf")

        for i in range(len(nums)):
            prefix*=nums[i]
            suffix*=nums[n-i-1]

            ans=max(ans,prefix,suffix)
            if prefix==0:
                prefix=1
            if suffix==0:
                suffix=1
        return ans
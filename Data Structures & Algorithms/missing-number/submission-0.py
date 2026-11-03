class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        xor=len(nums)
        #initialize to len because numbers are from 0 to n and loop is from 0 to n-1 thats why initialize it to len(nums)
        for i,num in enumerate(nums):
            xor=xor^i
            xor=xor^nums[i]
        return xor
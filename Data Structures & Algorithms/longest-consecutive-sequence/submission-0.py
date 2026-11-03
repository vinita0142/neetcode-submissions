class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen=set(nums)
        longest=0

        for num in seen:
            if num-1 not in seen:
                current = num
                current_length = 1
                while current + 1 in seen:
                    current+=1
                    current_length+=1
                longest=max(current_length,longest)
        return longest
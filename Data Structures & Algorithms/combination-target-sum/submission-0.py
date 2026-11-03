class Solution:



    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        result=[]
    


        def backtrack(index,current,current_sum):
            if current_sum==target:
                result.append(current.copy())
                return
            if current_sum>target or index==len(nums):
                return 
            
            current.append(nums[index])
            backtrack(index,current,current_sum+nums[index]);
            current.pop()
            backtrack(index+1,current,current_sum)
            
        backtrack(0,[],0)
        return result
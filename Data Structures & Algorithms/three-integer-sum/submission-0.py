class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        result=[]
        n=len(nums)

        for i in range(n):

            # skip duplicates
            if i>0 and nums[i]==nums[i-1]:
                continue
            left=i+1
            right=n-1

            while left<right:
                total=nums[i]+nums[left]+nums[right]
                #fixing i 
                if total==0:
                    result.append([nums[i],nums[left],nums[right]])
                    #skip duplicates
                    while left<right and nums[left]==nums[left+1]:
                        left+=1
                    while left<right and nums[right]==nums[right-1]:
                        right-=1
                
                    left+=1
                    right-=1
                    #set the next left and right 
                elif total < 0:
                    #need a bigger sum
                    left+=1
                else:
                    right-=1
        return result
            

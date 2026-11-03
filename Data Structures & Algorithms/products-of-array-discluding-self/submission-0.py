class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        if(len(nums)==1): 
            return [1]
        psum=[]
        ssum=[0]*len(nums)

        prev=1
        for n in nums:
            prev=n*prev
            psum.append(prev)

        prev=1

        for i in range(len(nums)-1,-1,-1):
            prev=prev*nums[i]
            ssum[i]=prev
        
        res=[]
        for i in range(0,len(nums)):
            if i==0:
                res.append(ssum[i+1])
            elif i==len(nums)-1:
                res.append(psum[i-1])
            else:
                pro=psum[i-1]*ssum[i+1]
                res.append(pro)
        return res

        
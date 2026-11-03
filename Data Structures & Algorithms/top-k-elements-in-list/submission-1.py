class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #frequency bucket -> values 


        freq={}
        for n in nums:
            freq[n]=freq.get(n,0)+1
        

        buckets=[[] for _ in range(len(nums)+1)]

        for num,f in freq.items():
            buckets[f].append(num)
        
        res=[]
        for i in range(len(buckets)-1,-1,-1):
            for num in buckets[i]:
                res.append(num)
                if len(res) == k:
                    return res
        return res

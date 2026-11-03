class Solution:
    def countBits(self, n: int) -> List[int]:
        res=[]

        for i in range(n+1):
            res.append(self.numberOfOnes(i))
        return res


    def numberOfOnes(self,n: int) -> int:
        count=0
        while n!=0:
            n = n & (n-1)
            count+=1
        return count        
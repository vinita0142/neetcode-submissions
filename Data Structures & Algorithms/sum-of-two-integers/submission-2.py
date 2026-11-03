class Solution:
    def getSum(self, a: int, b: int) -> int:
        
        MASK = 0xFFFFFFFF

        a=a&MASK
        b=b&MASK

        while b!=0:
            carry = (a&b)<<1
            a= (a ^ b) & MASK 
            b=carry & MASK
        
        if a> 0x7FFFFFFF:
            a = a - (1<<32)
        return a
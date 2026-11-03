class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        l=0
        r=len(s)-1
        s=s.lower()
        while l<=r:
            while l<len(s) and not s[l].isalnum():
                l+=1
            while r>=0 and not s[r].isalnum():
                r-=1
            if r>=0 and l<len(s) and s[l]!=s[r]:
                return False
            else:
                l+=1
                r-=1
        return True

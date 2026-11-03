class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        fmap={}

        left=0
        right=0
        ws=0
        while right<len(s):
            ch=s[right]
            if ch in fmap and fmap[ch]>=left:
                left=fmap[ch]+1
            ws=max(ws,right-left+1)
            fmap[ch]=right
            right+=1
        return ws

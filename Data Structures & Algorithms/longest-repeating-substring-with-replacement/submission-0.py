class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq={}
        left=0
        maxf=0
        longest=0

        for right in range(len(s)):
            ch=s[right]
            freq[ch]=freq.get(ch,0)+1
            maxf=max(maxf,freq[ch])

            #ws-maxf > k not possible
            ws=right-left+1
            replacements_req=ws-maxf

            if replacements_req > k:
                freq[s[left]]-=1
                left+=1
            longest=max(longest,right-left+1)
        return longest
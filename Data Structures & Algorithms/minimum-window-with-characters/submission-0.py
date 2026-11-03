class Solution:
    def minWindow(self, s: str, t: str) -> str:
        count={}

        for ch in t:
            count[ch]=count.get(ch,0)+1
        

        left=0
        min_length=float("inf")
        start_index=0

        required=len(t)
        for right in range(len(s)):
            ch = s[right]
            if ch in count:
                if count[ch]>0:  # at right we encounter ch, now check if ch is needed yes it, if yes reduce its count and reduce required also 
                    required-=1
                count[ch]-=1
            

            while required==0:
                ws=right-left+1
                if ws<min_length:
                    min_length=ws
                    start_index=left
                
                #now try shrinking
                left_ch=s[left]

                if left_ch in count:
                    count[left_ch]+=1
                    if count[left_ch] > 0:
                        required+=1
                left+=1
        
        if min_length==float("inf"): 
            return ""
        return s[start_index:start_index+min_length]

                    
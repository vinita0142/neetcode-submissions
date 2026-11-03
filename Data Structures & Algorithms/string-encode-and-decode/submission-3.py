class Solution:

    def encode(self, strs: List[str]) -> str:
        res=[]

        for s in strs:
            res.append(str(len(s))+"#"+s)
        print("".join(res))
        return "".join(res)
    

    def decode(self, s: str) -> List[str]:
        res=[]

        i=0
        while i < len(s):
            j=i
            while s[j]!='#':
                j+=1
            length=int(s[i:j])
            start=j+1
            end=start+length
            word=s[start:end]
            res.append(word)
            i=end

        return res

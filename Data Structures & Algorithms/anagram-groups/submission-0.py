class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        smap={}
        res=[]
        for s in strs:
            t=sorted(s)
            ans=""
            count={}
            for char in t:
                count[char]=count.get(char,0)+1
            
            for key,value in count.items():
                ans+=key+""+str(value)
             
            if ans not in smap:
                smap[ans]=[s]
            else:
                smap[ans].append(s)

        for r in smap.values():
            res.append(r)
        return res    
            
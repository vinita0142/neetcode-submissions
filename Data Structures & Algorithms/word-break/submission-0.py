class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words=set(wordDict)


        n=len(s)

        dp=[False]*(n+1)

        dp[0]=True

        for end in range(1,n+1):
            for start in range(end):
                word=s[start:end]

                if dp[start] and word in words:
                    dp[end]=True
                    break
        return dp[n]
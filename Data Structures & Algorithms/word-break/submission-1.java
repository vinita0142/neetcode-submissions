class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);

        int n=s.length();

        boolean dp[]=new boolean[n+1];


        //base case

        dp[n]=true;

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                String word=s.substring(i,j);
                if (set.contains(word) && dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

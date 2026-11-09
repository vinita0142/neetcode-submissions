class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m=s1.length();
        int n=s2.length();

        if(m+n!=s3.length()) return false;


        boolean[][] dp=new boolean[m+1][n+1];


        dp[m][n]=true;


        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==m && j==n){
                    continue;
                }

                boolean takes1=false;
                boolean takes2=false;


                if(i<m && s1.charAt(i)==s3.charAt(i+j)){
                    takes1=dp[i+1][j];
                }
                if(j<n && s2.charAt(j)==s3.charAt(i+j)){
                    takes2=dp[i][j+1];
                }

                dp[i][j]=takes1 || takes2;
            }

        }
        return dp[0][0];


    }
}

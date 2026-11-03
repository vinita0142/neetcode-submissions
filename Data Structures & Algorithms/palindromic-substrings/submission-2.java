class Solution {
    public int countSubstrings(String s) {
        int res=0;

        int left=0;
        int right=0;

        for(int i=0;i<s.length();i++){
            res+=expand(s,i,i);
            res+=expand(s,i,i+1);
        }
        return res;
    }

    public int expand(String s, int left, int right){
        int cnt=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            cnt++;
        }
        return cnt;
    }
}

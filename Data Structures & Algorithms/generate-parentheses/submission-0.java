class Solution {
    List<String> res=new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {

        backtrack(0,0,n,"");
        return res;
    }


    private void backtrack(int open, int close, int n, String path){
        if(open==n && close==n){
            res.add(path);
            return;
        }


        if(open<n){
            backtrack(open+1,close,n,path+"(");
        }

        if(close<open){
            backtrack(open,close+1,n,path+")");
        }
    }
}

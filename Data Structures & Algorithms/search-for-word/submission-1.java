class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;


        boolean[][] visited=new boolean[m][n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(bt(i,j,0,board,word, visited)){
                    return true;
                }
            }
        }
        return false;
    }

 
    private boolean bt(int i,int j,int c,char[][] board,String word,boolean[][] visited){
        if(c==word.length()){
            return true;
        }


        if(i<0 || j<0|| i>=board.length || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(c)){
            return false;
        }

        visited[i][j]=true;


        boolean found=bt(i+1,j,c+1,board,word,visited) ||
        bt(i-1,j,c+1,board,word,visited) ||
        bt(i,j+1,c+1,board,word,visited) ||
        bt(i,j-1,c+1,board,word,visited);


        visited[i][j]=false;

        return found; 
    }
}

class Solution {

    int[][] directions={
        {1,0},
        {-1,0},
        {0,-1},
        {0,1}
    };

    public void solve(char[][] board) {

        int rows=board.length;
        int cols=board[0].length;


        boolean[][] vis=new boolean[rows][cols];

        //traverse first and last row 


        for(int j=0;j<cols;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0,j,vis,board);
            }

            if(!vis[rows-1][j] && board[rows-1][j]=='O'){
                dfs(rows-1,j,vis,board);
            }
        }

        //traverse first and last col

        for(int i=0;i<rows;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i,0,vis,board);
            }

            if(!vis[i][cols-1] && board[i][cols-1]=='O'){
                dfs(i,cols-1,vis,board);
            }
        }


        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(!vis[r][c] && board[r][c]=='O'){
                    board[r][c]='X';
                }
            }
        }


    }


    private void dfs(int r,int c,boolean visited[][], char[][] grid){
        visited[r][c]=true;

        for(int[] dir: directions){
            int nr=r+dir[0];
            int nc=c+dir[1];

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='O' && !visited[nr][nc]){
                dfs(nr,nc,visited,grid);
            }
        }



    }
}

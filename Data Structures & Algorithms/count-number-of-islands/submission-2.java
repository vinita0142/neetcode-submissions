class Solution {



    int[][] directions={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public void dfs(char[][] grid, int r,int c, boolean[][] visited){
        int rows=grid.length;
        int cols=grid[0].length;


        if(r<0 || r>=rows || c<0 || c>=cols){
            return;
        }
        if(grid[r][c]=='0' || visited[r][c]){
            return;
        }

        visited[r][c] = true;

        for(int[] dir: directions){
            int nr=r+dir[0];
            int nc=c+dir[1];

            dfs(grid,nr,nc,visited);
        }
    }

    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean visited[][] =new boolean[rows][cols];


        int islands=0;


        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1' && !visited[r][c]){
                    islands++;
                    dfs(grid,r,c,visited);
                }
            }
        }
        return islands;
    }
}

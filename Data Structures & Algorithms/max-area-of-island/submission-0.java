class Solution {


    int[][] directions={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };



    public void dfs(int[][] grid,int r,int c, boolean[][] visited,int[] area){
        int rows=grid.length;
        int cols=grid[0].length;


        if(r<0 || r>=rows || c<0 || c>=cols ){
            return;
        }

        if(grid[r][c]==0 || visited[r][c]){
            return;
        }


        visited[r][c]=true;
        area[0]++;

        for(int[] dr: directions){
            int nr=r+dr[0];
            int nc=c+dr[1];

            dfs(grid,nr,nc,visited,area);
        }
    }


    public int maxAreaOfIsland(int[][] grid)    {
        

        int rows=grid.length;
        int cols=grid[0].length;
        int[] area=new int[1];
        int max_area=0;
        boolean visited[][]=new boolean[rows][cols];


        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1 && !visited[r][c]){

                area[0]=0;    dfs(grid,r,c,visited,area);
                max_area=Math.max(area[0],max_area);
                }
            }
        }
        return max_area;
    }


    
}

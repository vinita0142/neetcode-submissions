class Solution {
    
    int[][] directions= {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> q=new ArrayDeque<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }


        //expand from all sources

        while(!q.isEmpty()){
            int[] cell=q.poll();

            int r=cell[0];
            int c=cell[1];

            for(int[] dir: directions){
                int nr=r+dir[0];
                int nc=c+dir[1];


                if(nr<0 || nr>=rows || nc<0 || nc>=cols){
                    continue;
                }

                //skip walls treasures and visited cells

                if(grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc]=grid[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
        }    
    }
}

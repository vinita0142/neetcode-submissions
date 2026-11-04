class Solution {


    int[][] directions = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> q=new ArrayDeque<>();

        int fresh=0;
        int minutes=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
                else if(grid[r][c]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] cell=q.poll();
                int r=cell[0];
                int c=cell[1];
                
                //process one minute
                for(int[] dir: directions){
                    int nr=r+dir[0];
                    int nc=c+dir[1];

                    if(nr<0 || nr>=rows || nc<0 || nc>=cols){
                        continue;
                    }

                    //skip empty or already rotten cells

                    if (grid[nr][nc]!=1){
                        continue;
                    }


                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});


                }
            }
            minutes++;
        }

        return fresh==0?minutes:-1;

    }
}

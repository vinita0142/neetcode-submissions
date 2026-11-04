class Solution {


    int[][] directions ={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        List<List<Integer>> res=new ArrayList<>();
        boolean[][] visp=new boolean[rows][cols];
        boolean[][] visa=new boolean[rows][cols];


        for(int c=0;c<cols;c++){
            dfs(0,c,heights,visp);
            dfs(rows-1,c,heights,visa);
        }

        for(int r=0;r<rows;r++){
            dfs(r,0,heights,visp);
            dfs(r,cols-1,heights,visa);
        }


        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(visp[r][c] && visa[r][c]){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    res.add(temp);
                }
            }
        }
        return res;
    }



    public void dfs(int r,int c, int[][] heights, boolean[][] visited){

        if(visited[r][c]) return;


        visited[r][c]=true;
        for(int[] dir: directions){
            int nr=r+dir[0];
            int nc=c+dir[1];

            if(nr<0 || nr>=heights.length || nc<0 || nc>=heights[0].length){
                continue;
            }

            if(heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,visited);
            }
        
        }
    }
}

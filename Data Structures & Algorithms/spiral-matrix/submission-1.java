class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();

        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;


        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                res.add(matrix[top][j]);
            }

            top++;

            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;


            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }

                left++;
            }

        }
        return res;

    }
}




/*

1 2 3
4 5 6
7 8 9

up=0
down=2
left=0
right=2



*/
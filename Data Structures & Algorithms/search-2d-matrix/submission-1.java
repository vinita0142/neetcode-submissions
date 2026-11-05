class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //4 ->   (1,0) 3+1  -> 4/3   4%4 
        //5->    (1,1) 5/3 -> 1 5%4 1


        int low=0;
        int r=matrix.length;
        int c=matrix[0].length;
        int high=r*c-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int row=mid/c;
            int col=mid%c;
            if(matrix[row][col]==target){
                return true;
            }
            else if(target<=matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;

    }
}

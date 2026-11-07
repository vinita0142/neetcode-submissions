class Solution {
    public int maxArea(int[] heights) {
        int max=Integer.MIN_VALUE;

        int left=0;
        int right=heights.length-1;


        while(left<right){
            int area=(right-left)*Math.min(heights[left],heights[right]);
            max=Math.max(area,max);

            if(heights[left]>heights[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}

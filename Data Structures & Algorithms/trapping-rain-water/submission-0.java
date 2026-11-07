class Solution {
    public int trap(int[] heights) {
        

        int left=0;

        int right=heights.length-1;

        int leftMax=0;
        int rightMax=0;
        int totalWater=0;

        while(left<=right){
            leftMax=Math.max(leftMax,heights[left]);
            rightMax=Math.max(rightMax,heights[right]);


            if(leftMax<=rightMax){
                totalWater+=leftMax-heights[left];
                left++;
            }
            else{
                totalWater+=rightMax-heights[right];
                right--;
            }


        }
        return totalWater;
    }
}

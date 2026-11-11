class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack=new Stack<>();

        int maxArea=0;

        for(int i=0;i<heights.length;i++){
            int start=i;

            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] prev=stack.pop();
                int index=prev[0];
                int height=prev[1];

                int area=height*(i-index);
                maxArea=Math.max(maxArea,area);

                start=index;
            }

            stack.push(new int[]{start,heights[i]});
        }

        for(int[] rem: stack){
            int index=rem[0];
            int height=rem[1];

            int area=height*(heights.length-index);
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
}

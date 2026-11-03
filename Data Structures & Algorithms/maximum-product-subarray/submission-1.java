class Solution {
    public int maxProduct(int[] nums) {
//         //One direction can miss the best product when a negative number changes the sign.
//         1. If either running product becomes zero, reset it to 1.
// Why reset to 1?

// Because zero breaks a contiguous product into separate segments.

        int n=nums.length;

        int leftPro=1;
        int rightPro=1;

        int maxPro=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            leftPro*=nums[i];
            rightPro*=nums[n-i-1];

            maxPro=Math.max(maxPro,Math.max(leftPro,rightPro));

            if(leftPro==0) leftPro=1;
            if(rightPro==0) rightPro=1;
        }
        return maxPro;


    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;

        int[] res=new int[2];

        while(left<right){
            int a=numbers[left];
            int b=numbers[right];

            if(a+b==target){
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }
            else if(a+b>target){
                right--;
            }
            else{
                left++;
            }
        }
        return res;
    }
}

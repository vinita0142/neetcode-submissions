class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;


        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast);


        int slow2=0;

        while(slow2!=fast){
            slow2=nums[slow2];
            fast=nums[fast];
        }

        return slow2;
    }
}

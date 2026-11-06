class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        


        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }


        int m=nums1.length;
        int n=nums2.length;

        int totalleft=(m+n+1)/2;

        int low=0;
        int high=m;

        while(low<=high){
            int aCount=low+(high-low)/2;

            int bCount=totalleft-aCount;

            int Aleft =(aCount==0)?Integer.MIN_VALUE:nums1[aCount-1];

            int Aright =(aCount==m)?Integer.MAX_VALUE:nums1[aCount];

            int Bleft=(bCount==0)?Integer.MIN_VALUE:nums2[bCount-1];
            int Bright=(bCount==n)?Integer.MAX_VALUE:nums2[bCount];


            if(Aleft<=Bright && Bleft<=Aright){
                //odd total length


                if((m+n)%2==1){
                    return Math.max(Aleft,Bleft);
                }

                return ((double)Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;

                
            }

            else if(Aleft>Bright){
                high=aCount-1;
            }
            else{
                low=aCount+1;
            }

        }
        return -1;
    }
}

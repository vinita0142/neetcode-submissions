class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(piles[i],max);
        }
        int high=max;
        int ans=-1;
        while(low<=high){
            
            int mid=low+(high-low)/2;

            if(canEatBananas(mid,piles,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean canEatBananas(int k, int[] piles, int h){
        long hours_required=0;

        for(int i=0;i<piles.length;i++){
            hours_required+=(int)Math.ceil(piles[i]/(double)k);
        }

        return hours_required<=h;
    }
}

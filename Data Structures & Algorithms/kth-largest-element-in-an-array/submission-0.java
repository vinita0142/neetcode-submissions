class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();


        for(int i=0;i<nums.length;i++){
            if(pq.size()==k){
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
            else{
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}

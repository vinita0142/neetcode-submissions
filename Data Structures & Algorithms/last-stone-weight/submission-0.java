class Solution {
    public int lastStoneWeight(int[] stones) {
        

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        if(stones.length==1){
            return stones[0];
        }

        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }

        while(pq.size()>=2){
            int l1=pq.poll();
            int l2=pq.poll();

            if (l1!=l2){
                pq.offer(l1-l2);
            }
        }

        if(pq.size()!=0){
            return pq.poll();
        }
        else return 0;        
    }
}

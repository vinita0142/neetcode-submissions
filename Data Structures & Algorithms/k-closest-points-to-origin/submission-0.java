class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(
            (a,b)-> Long.compare(
                (long)b[0]*b[0]+(long)b[1]*b[1],

                (long)a[0]*a[0]+(long)a[1]*a[1]
            )
        );


        for(int[] point:points){
            minHeap.offer(point);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[][] result=new int[k][2];

        for(int i=0;i<k;i++){
            result[i]=minHeap.poll();
        }

        return result;



    }
}

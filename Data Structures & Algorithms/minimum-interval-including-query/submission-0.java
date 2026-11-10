class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int n=queries.length;
        int[][] sortedQueries=new int[n][2];

        for(int i=0;i<n;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }

        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int[] res=new int[n];
        Arrays.fill(res,-1);

        int i=0;

        for(int[] q:sortedQueries){
            int query=q[0];
            int ori=q[1];


            while(i<intervals.length && intervals[i][0]<=query){
                int start=intervals[i][0];
                int end=intervals[i][1];

                int len=end-start+1;
                minHeap.offer(new int[]{len,end});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1]<query){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                res[ori]=minHeap.peek()[0];
            }
        }
        return res;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res=new ArrayList<>();

        int[] prev=intervals[0];

        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];

            if(prev[1]>=start){
                prev[0]=Math.min(prev[0],start);
                prev[1]=Math.max(prev[1],end);
            }
            else{
                res.add(prev);
                prev=intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int nstart=newInterval[0];
        int nend=newInterval[1];

        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];

            //existing interval is before new interval
            if(end<nstart){
                res.add(intervals[i]);
            }
            //existing interval is after new interval
            else if(nend<start){
                res.add(new int[]{nstart,nend});

                for(int j=i;j<intervals.length;j++)
                    res.add(intervals[j]);
                return res.toArray(new int[res.size()][]);
            }
            else{
                nstart=Math.min(nstart,start);
                nend=Math.max(nend,end);
            }


        }

        res.add(new int[]{nstart,nend});
        return res.toArray(new int[res.size()][]);
    }
}

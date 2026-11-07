class Solution {
    public int leastInterval(char[] tasks, int n) {
        

        int[] freq=new int[26];

        for(char c:tasks){
            freq[c-'A']++;
        }


        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());


        for(int count: freq){
            if(count>0){
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldown=new ArrayDeque<>();
        int time=0;


        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!cooldown.isEmpty() && cooldown.peek()[1]<=time){
                int[] ready=cooldown.poll();
                maxHeap.offer(ready[0]);
            }


            //execute the most freq available task 

            if(!maxHeap.isEmpty()){
                int count=maxHeap.poll();
                count--;

                if(count>0){
                    cooldown.offer(new int[]{count,time+n+1});
                }
            }
        }
        return time;
    
    }
}

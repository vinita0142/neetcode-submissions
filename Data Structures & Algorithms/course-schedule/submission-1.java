class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree=new int[numCourses];

        ArrayList<ArrayList<Integer>> adj=buildAdjList(numCourses,prerequisites,indegree);


        Queue<Integer> q=new LinkedList<>();


        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        ArrayList<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){


            int node=q.remove();

            topo.add(node);

            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }

        return numCourses==topo.size();

    }


    public ArrayList<ArrayList<Integer>> buildAdjList(int numCourses, int[][] edges, int[] indegree){




        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }



        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }


        return adj;
    }
}

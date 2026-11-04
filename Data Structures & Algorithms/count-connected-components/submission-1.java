class Solution {
    public int countComponents(int n, int[][] edges) {
       

        boolean visited[]=new boolean[n];

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();


        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);    
        }

        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;

    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        visited[node]=true;
        for(int nei: adj.get(node)){
            if(!visited[nei]) dfs(nei,adj,visited);
        }

    }
}

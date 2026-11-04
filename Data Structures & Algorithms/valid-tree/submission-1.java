class Solution {
    public boolean validTree(int n, int[][] edges) {
List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if(dfs(0,-1,adj,visited)){
            return false;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited){
        visited[node]=true;
        for(int nei: adj.get(node)){
            if (!visited[nei]){
                dfs(nei,node,adj,visited);
            }
            else if(nei!=parent){
                return true;
            }
        }
        return false;
    }
}

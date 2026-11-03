class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:

        # Build adjacency list
        adj = [[] for _ in range(n)]

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = set()

        def dfs(node, parent):

            visited.add(node)

            for nei in adj[node]:

                # Ignore the edge we used to come here
                if nei == parent:
                    continue

                # Visited neighbor other than parent = cycle
                if nei in visited:
                    return False

                if not dfs(nei, node):
                    return False

            return True

        # Start DFS from node 0
        if not dfs(0, -1):
            return False

        # If some nodes were never reached, graph is disconnected
        return len(visited) == n
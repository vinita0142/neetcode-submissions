class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj=[[] for _ in range(numCourses)]

        indegree=[0] * numCourses

        for course,prerequisite in prerequisites:
            # u, v , v before u so v -> u
            adj[prerequisite].append(course)
            indegree[course]+=1
        
        q=deque()

        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)

        processed=0

        while q:
            course =q.popleft()
            processed+=1

            for nei in adj[course]:
                indegree[nei]-=1

                if indegree[nei]==0:
                    q.append(nei)

        return processed==numCourses
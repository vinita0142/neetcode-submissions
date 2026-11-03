class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows=len(board)
        cols=len(board[0])

        path=set()


        def dfs(r,c,index):
            if index==len(word):
                return True
            if r<0 or r>=rows or c<0 or c>=cols:
                return False
            

            if board[r][c] != word[index]:
                return False
            
            if (r,c) in path:
                return False
            
            path.add((r,c))

            found = dfs(r+1,c,index+1) or dfs(r-1,c,index+1) or dfs(r,c+1,index+1) or dfs(r,c-1,index+1)

            path.remove((r,c))

            return found


        for r in range(rows):
            for c in range(cols):
                if dfs(r,c,0):
                    return True
        return False
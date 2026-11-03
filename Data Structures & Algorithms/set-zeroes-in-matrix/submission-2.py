class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        
        rows=len(matrix)
        cols=len(matrix[0])

        row0=False
        col0=False

        for j in range(cols):
            if matrix[0][j] == 0:
                row0=True

        for i in range(rows):
            if matrix[i][0] == 0:
                col0=True
        
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][j]==0:
                    matrix[0][j]=0
                    matrix[i][0]=0

        for i in range(1,rows):
            for j in range(1,cols):
                if matrix[0][j]==0 or matrix[i][0]==0:
                    matrix[i][j]=0
        
        if row0:
            for j in range(cols):
                matrix[0][j]=0
        if col0:
            for i in range(rows):
                matrix[i][0]=0
        
class Solution {

    List<List<String>> res=new ArrayList<>();

    Set<Integer> cols=new HashSet<>();
    Set<Integer> posDiag=new HashSet<>();
    Set<Integer> negDiag=new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];

        for(int r=0;r<n;r++){
            Arrays.fill(board[r],'.');
        }    

        backtrack(0,n,board);
        return res;
    }


    private void backtrack(int r,int n, char[][] board){
        if(r==n){
            List<String> solution=new ArrayList<>();

            for(char[] row:board){
                solution.add(new String(row));
            }
            res.add(solution);
            return;
        }

        for(int c=0;c<n;c++){
            if(cols.contains(c) || negDiag.contains(r-c) || posDiag.contains(r+c)){
                continue;
            }

            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c]='Q';
            backtrack(r+1,n,board);
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c]='.';
        }
    }
}

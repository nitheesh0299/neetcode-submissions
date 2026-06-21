class Solution {
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean visited[][] = new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            if(board[r][0]=='O' && !visited[r][0]){
                dfs(r,0,board,visited);
            }
            if(board[r][cols-1]=='O' && !visited[r][cols-1]){
                dfs(r,cols-1,board,visited);
            }
        }

        for(int c=0;c<cols;c++){
            if(board[0][c]=='O' && !visited[0][c]){
                dfs(0,c,board,visited);
            }
            if(board[rows-1][c]=='O' && !visited[rows-1][c]){
                dfs(rows-1,c,board,visited);
            }
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c] =='Y'){
                    board[r][c] = 'O';
                }else{
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board, boolean[][] visited){

        visited[row][col] =true;
        board[row][col] = 'Y';

        for(int i=0;i<4;i++){
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];

            if(nr>=0 && nc>=0 && nr < board.length && nc < board[0].length
            && !visited[nr][nc] && board[nr][nc] == 'O'){
                dfs(nr,nc,board,visited);
            }

        }
    }
}

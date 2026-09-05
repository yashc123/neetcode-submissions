class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O' && (r == 0 || r == rows - 1 || c == 0 || c == cols - 1)){
                    dfs(board, r, c, rows, cols);
                }
            }
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if(board[r][c] == 'S'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, int rows, int cols){
        if(r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'S';
        dfs(board, r + 1, c, rows, cols);
        dfs(board, r - 1, c, rows, cols);
        dfs(board, r, c + 1, rows, cols);
        dfs(board, r, c - 1, rows, cols);
    }
}

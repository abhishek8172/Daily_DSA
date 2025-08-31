class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;

        dfs(board);
    }

    private boolean dfs(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;

                            if(dfs(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int i, int j, char ch){
        int boxRow = (i/3) * 3;
        int boxCol = (j/3) * 3;
        for(int k = 0; k < 9; k++){
            if(board[k][j] == ch) return false;
            if(board[i][k] == ch) return false;
            
            int row = boxRow + k/3;
            int col = boxCol + k%3;

            if(board[row][col] == ch) return false;
        }

        return true;
    }

}
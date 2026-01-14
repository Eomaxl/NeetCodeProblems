package org.ds.array.medium;

public class WordSearch {
    private  int rows;
    private  int cols;
    private  char[][] board;
    public static void main(){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch obj = new WordSearch();
        System.out.println("Does the word exists in the board : "+obj.exist(board, word));
    }

    public boolean exist(char[][] board, String str){
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for(int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                if (backtrack(row, col, str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String str, int index){
        if (index >= str.length()){
            return true;
        }

        if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != str.charAt(index)){
            return false;
        }

        boolean result = false;
        this.board[row][col] = '#';
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d<4; ++d){
            result = this.backtrack(row + rowOffsets[d], col + colOffsets[d], str, index + 1);
            if (result)
                break;
        }
        this.board[row][col] = str.charAt(index);
        return result;
    }
    
}

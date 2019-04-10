import java.util.Arrays;

public class RecursionQueen {
//    private int[][] board;

    public static void displayboard(int[][] board){
        for (int[] row: board) {
            System.out.println(Arrays.toString(row));
        }

    }
    
    public static boolean noThreat(int[][] board, int row, int col){
        //check row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1){
                return false;
            }
        }

        //check diagonal, decrease a row, decrease a column
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1){
                return false;
            }
        }
        //check other diagonal, increase a row, decrease a column
        for (int i = row, j = col; i < 8 && j >= 0; i++, j--) {
            if (board[i][j]==1){
                return false;
            }
        }
        return true;
    }

    private static boolean solveBoard(int[][] board, int col){
        //base case: all 8 queens placed successfully
        if (col >= 8){
            return true;
        }

        //for every column, check every row until safe one is found
        for (int row = 0; row < 8; row++) {
            if (noThreat(board, row, col)){
                board[row][col] = 1; //place queen here

                //try next column (col+1)
                if (solveBoard(board, col+1) == true){
                    return true;
                }
                board[row][col] = 0;
            }

        }
//        displayboard(board);
        return false; //threat at all rows, solveboard for next column returns false and skips if statement,
        // sets board[row][col] to 0 and tries to place in next row
    }

    public static boolean solve(){
        int[][] board = new int[8][8];
//        displayboard(board);
        solveBoard(board, 0);
        displayboard(board);
        return true;
    }

    public static void main(String[] args) {
        solve();
    }
}

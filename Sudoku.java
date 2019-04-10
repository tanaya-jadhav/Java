import java.util.Arrays;

public class Sudoku {
    public static void displayboard(int[][] board){
        for (int[] row: board) {
            System.out.println(Arrays.toString(row));
        }

    }

    //check if valid
    private static boolean inRow(int[][] board, int row, int num){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean inColumn(int[][] board, int col, int num){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean isvalid(int[][] board, int row, int col, int num){
        //check if in row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num){
                return false;
            }
        }

        //check if in column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num){
                return false;
            }
        }

        //check if in box
        int rowStart = row -row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean solveBoard(int[][] board){
//        if (row >= 9 && col >= 9){
//            return true;
//        }
        boolean isEmpty = false;
        int row = 0;
        int col = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty){
                break;
            }
        }

        if (isEmpty == false){
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isvalid(board, row, col, num)) {
                board[row][col] = num;
                if (solveBoard(board) == true) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }


//        if (board[row][col] == 0) {
//            for (int num = 1; num <= 9; num++) {
//                if (isvalid(board, row, col, num)) {
//                    board[row][col] = num;
//                    displayboard(board);
//                    System.out.println();
//
//                    if (col <= 7) {
//                        if (solveBoard(board, row, col + 1) == true) {
//                            return true;
//                        }
//                    } else if (col == 8 && row <= 7) {
//                        if (solveBoard(board, row + 1, 0) == true) {
//                            return true;
//                        }
//
//                    }
//                    board[row][col] = 0;
//                }
//            }
////        }
//        } else if (col <= 7){
//            solveBoard(board, row, col+1);
//        } else {
//            solveBoard(board, row+1, 0);
//        }

        return false;
    }

    private static boolean solve(int[][] board){
//        displayboard(board);
        solveBoard(board);
        displayboard(board);
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}};
        solve(board);

    }
}

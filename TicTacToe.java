import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private boolean isXturn;
    private static boolean restart;

    public TicTacToe(char[][] board) {
        this.board = board;
        this.isXturn = true;
    }

    public void displayBoard() {
        String rowOne = Arrays.toString(board[0]);
        String rowTwo = Arrays.toString(board[1]);
        String rowThree = Arrays.toString(board[2]);
        String rows = rowOne + "\n" + rowTwo + "\n" + rowThree;
        System.out.println(rows);
    }

    public void addMove(int row, int col, char player) {
        if (player == 'O') {
            this.board[row] [col] = 'O';
        }
        else {
            this.board[row][col] = 'X';
        }

    }

    private boolean noWinner() {
        if (this.board[0][0] == 'X') {
            if (this.board[0][1] == 'X' && this.board[0][2] == 'X') {
                System.out.println("First player has won!");
                return false;
            } else if (this.board[1][0] == 'X' && this.board[2][0] == 'X') {
                System.out.println("First player has won!");
                return false;
            } else if (this.board[1][1] == 'X' && this.board[2][2] == 'X') {
                System.out.println("First player has won!");
                return false;
            }

        } else if (this.board[0][0] == 'O') {
            if (this.board[0][1] == 'O' && this.board[0][2] == 'O') {
                System.out.println("Second player has won!");
                return false;
            } else if (this.board[1][0] == 'O' && this.board[2][0] == 'O') {
                System.out.println("Second player has won!");
                return false;
            } else if (this.board[1][1] == 'O' && this.board[2][2] == 'O') {
                System.out.println("Second player has won!");
                return false;
            }
        }
            if (this.board[0][1] == 'X') {
                if (this.board[1][1] == 'X' && this.board[2][1] == 'X') {
                    System.out.println("First player has won!");
                    return false;
                }
            } else if (this.board[0][1] == 'O') {
                if (this.board[1][1] == 'O' && this.board[2][1] == 'O') {
                    System.out.println("Second player has won!");
                    return false;
                }
            }
            if (this.board[0][2] == 'X') {
                if (this.board[1][2] == 'X' && this.board[2][2] == 'X') {
                    System.out.println("First player has won!");
                    return false;
                } else if (this.board[1][1] == 'X' && this.board[2][0] == 'X') {
                    System.out.println("First player has won!");
                    return false;
                }
            } else if (this.board[0][2] == 'O') {
                if (this.board[1][2] == 'O' && this.board[2][2] == 'O') {
                    System.out.println("Second player has won!");
                    return false;
                } else if (this.board[1][1] == 'O' && this.board[2][0] == 'O') {
                    System.out.println("Second player has won!");
                    return false;
                }
            }
            if (this.board[1][0] == 'X' && this.board[1][1] == 'X' && this.board[1][2] == 'X') {
                System.out.println("First player has won!");
                return false;
            } else if (this.board[1][0] == 'O' && this.board[1][1] == 'O' && this.board[1][2] == 'O') {
                System.out.println("Second player has won!");
                return false;
            }

            if (this.board[2][0] == 'X' && this.board[2][1] == 'X' && this.board[2][2] == 'X') {
                System.out.println("First player has won!");
                return false;
            } else if (this.board[2][0] == 'O' && this.board[2][1] == 'O' && this.board[2][2] == 'O') {
                System.out.println("Second player has won!");
                return false;
            }
        return true;
    }




    public static boolean restart() {
        Scanner restart = new Scanner(System.in);
        System.out.println("Would you like to start the game? Enter 1 for yes or 0 for no");
        int ans = Integer.parseInt(restart.nextLine());
        if (ans == 1) {
            return true;
        }
        return false;
    }


    private void whoseTurn(int turn) {
        if (turn%2 == 1) {
            String decision = "it's First player's turn (X)";
            System.out.println(decision);;
        }
        else {
            String decision = "it's Second player's turn (O)";
            System.out.println(decision);;
        }
    }

    public static void main(String[] args) {
        while (restart()) {
            System.out.println("The board has 3 rows: 1, 2 & 3 going from top to bottom. \nIt has 3 columns: 1, 2 & 3 going from left to right. \n");
            char[][] CleanBoard = new char[3][3];
            TicTacToe firstgame = new TicTacToe(CleanBoard);
            Scanner scanner = new Scanner(System.in);
            for (int turn = 1; turn <= 5; turn++) {
                firstgame.whoseTurn(turn);
                System.out.println("Enter the row number you would like to mark");
                int row = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.println("Enter the column number you would like to mark");
                int column = Integer.parseInt(scanner.nextLine()) - 1;
                if (turn % 2 == 1) {
                    firstgame.addMove(row, column, 'X');
                } else {
                    firstgame.addMove(row, column, 'O');
                }
                firstgame.displayBoard();
            }

            int turn = 6;
            while (firstgame.noWinner()) {
                firstgame.whoseTurn(turn);
                System.out.println("Enter the row number you would like to mark");
                int row = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.println("Enter the column number you would like to mark");
                int column = Integer.parseInt(scanner.nextLine()) - 1;
                if (turn % 2 == 1) {
                    firstgame.addMove(row, column, 'X');
                } else {
                    firstgame.addMove(row, column, 'O');
                }

                turn++;
                firstgame.displayBoard();
                if (turn == 10) {
                    restart();
                }

            }

        }
    }
}

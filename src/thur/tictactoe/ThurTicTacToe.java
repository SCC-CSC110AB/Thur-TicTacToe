package thur.tictactoe;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class ThurTicTacToe {

    public static boolean isRowOrColumnValid(int rowOrCol) {
        return rowOrCol >= 0 && rowOrCol < GameBoard.BOARD_SIZE;
    }

    public static int[] getRowAndColFromUser(GameBoard board) {
        Scanner stdin = new Scanner(System.in);
        int[] result = new int[2];
        boolean isValid = false;
        int row = 0;
        int col = 0;

        do {
            try {
                if (board.getIsPlayerOnesTurn()) {
                    System.out.println("Player One's Turn (X): ");
                } else {
                    System.out.println("Player Two's Turn (O): ");
                }

                System.out.println("Enter row value: ");
                row = stdin.nextInt();

                System.out.println("Enter column value: ");
                col = stdin.nextInt();

                if (isRowOrColumnValid(row) && isRowOrColumnValid(col)) {
                    if (board.isEmpty(row, col)) {
                        isValid = true;
                    } else {
                        System.out.println(
                            "Square is already taken! "
                            + "Please choose another one."
                        );
                    }
                } else {
                    System.out.println("Row or col is outside of valid range.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
                stdin.nextLine();
            }
        } while (!isValid);

        result[0] = row;
        result[1] = col;

        return result;
    }

    public static void playRoundOfTicTacToe() {
        GameBoard board = new GameBoard();
        BoardToken winner;

        do {
            int[] rowAndCol;
            int row;
            int col;
            BoardToken token;

            System.out.println(board);

            rowAndCol = getRowAndColFromUser(board);
            row = rowAndCol[0];
            col = rowAndCol[1];
            
            if (board.getIsPlayerOnesTurn()) {
                token = BoardToken.createXToken();
            } else {
                token = BoardToken.createOToken();
            }
            
            board.placeToken(row, col, token);
        } while (!board.isGameOver());
        
        winner = board.getWinner();
        
        if (winner.equals(BoardToken.createXToken())) {
            System.out.println("Player 1 wins!");
        } else if (winner.equals(BoardToken.createOToken())) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Cat's game");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("It's time for Tic-Tac-Toe you female dog you.");

        playRoundOfTicTacToe();
    }

}

package thur.tictactoe;

/**
 *
 * @author john
 */
public class GameBoard {
    public static final int BOARD_SIZE = 3;
    
    BoardToken[][] boardState;
    boolean isPlayerOnesTurn;
    
    public GameBoard() {
        boardState = new BoardToken[BOARD_SIZE][BOARD_SIZE];
        isPlayerOnesTurn = true;
        
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                boardState[i][j] = BoardToken.createEmptyToken();
            }
        }
    }
    
    public void placeToken(int row, int col, BoardToken userToken) {
        boardState[row][col] = userToken;
        isPlayerOnesTurn = !isPlayerOnesTurn;
    }
    
    public boolean isEmpty(int row, int col) {
        return boardState[row][col].equals(BoardToken.createEmptyToken());
    }
    
    public BoardToken getWinner() {
        return BoardToken.createEmptyToken();
    }
    
    public boolean isGameOver() {
        return false;
    }
    
    public boolean getIsPlayerOnesTurn() {
        return this.isPlayerOnesTurn;
    }
    
    public String toString() {
        String result = "\n";
        
        for (int i = 0; i < this.boardState.length; i++) {
            if (i != 0) {
                result += "-+-+-\n";
            }
            
            for (int j = 0; j < this.boardState[i].length; j++) {
                if (j != 0) {
                    result += "|";
                }
                
                result += this.boardState[i][j];
            }
            
            result += "\n";
        }
        
        result += "\n";
        
        return result;
    }
}

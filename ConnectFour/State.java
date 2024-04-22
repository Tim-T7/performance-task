package ConnectFour; 

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_ROW][Constants.BOARD_COL];

    public boolean isWinner() {
        int total; 
        for (int row=0; row<Constants.BOARD_ROW; row++) {
            total = getBoardCell(row , 0) +
            getBoardCell (row, 1) +
            getBoardCell (row, 2) +
            getBoardCell (row, 3);
            if (total ==-4||total == 4) return true;
        }
        for (int col =0; col<Constants.BOARD_COL; col++) {
            total = getBoardCell (0,col) + 
            getBoardCell (1,col) +
            getBoardCell (2,col) +
            getBoardCell (3, col);
            if (total==-4||total ==4) return true;
        }
        for (int row = 0; row <= Constants.BOARD_ROW - 4; row++) {
            for (int col = 0; col <= Constants.BOARD_COL - 4; col++) {
                if (checkFourInARow (row, col, 1, 1) || checkFourInARow(row, col + 3, 1, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkFourInARow(int Row, int Col, int rowIncrement, int colIncrement) {
        int player = getBoardCell(Row, Col);
        if (player == Constants.BLANK) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            int row=Row + i * rowIncrement;
            int col = Col + i* colIncrement;
            int value = getBoardCell(row, col);
            if (value != player){
                return false;
            }
        }

        return true;
    }

    public boolean isTie() {
        // You will write this code too!!
        for (int row=0; row<Constants.BOARD_ROW; row++) {
            for (int col=0; col<Constants.BOARD_COL; col++) {
                if (getBoardCell(row,col )== Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public void clearBoard(){
        for (int row = 0; row <6; row++){
            for (int col = 0; col <7; col++){
                setBoardCell(row,col,Constants.BLANK);
            }
        }
    }

}
package ConnectFour;
import java.util.Scanner;

/**
 * UI class
 */
public class UI 
{

    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);         
    }
    // Utility methods
    public String getXOrO(int whoseMove) {
        if (whoseMove == -1) {
            return "X";
        } else if (whoseMove == 1) {
            return "O";
        } else {
            return " ";
        }
    }

    public String getPlayerName(int whoseMove, String xName, String oName) {
        return (whoseMove == -1) ? xName : oName;
    }

    public boolean isLegalMove(State state, int row, int col) {
        return 1 <= row && row <= Constants.BOARD_ROW &&
        1 <= col && col <= Constants.BOARD_COL &&
        state.getBoardCell(row-1, col-1) == Constants.BLANK;
    }

    // Prompt for input methods
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();

    }

    public int getMoveRow(int whoseMove, String xName, String oName) {
        int row =0;
        while (true) {
            System.out.printf(Constants.GET_ROW_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
            try {
                row = scanner.nextInt();
                if (row < 1 || row > 6) {
                    printInvalidRowOrColumn();
                    System.out.println();
                    scanner.nextLine();
                } else {
                    return row;
                }
            } catch (Exception e) {
                printInvalidRowOrColumn();
                System.out.println();
                scanner.nextLine();
            }
        }
    }

    public int getMoveCol(int whoseMove, String xName, String oName) {
        int col =0;
        while (true) {
            System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove, xName, oName));
            try {
                col = scanner.nextInt();
                if (col < 1 || col > 7) {
                    printInvalidRowOrColumn();
                    System.out.println();
                    scanner.nextLine();
                } else {
                    return col;
                }
            } catch (Exception e) {
                printInvalidRowOrColumn();
                System.out.println();
            }
        }
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.equals ("Y") || yesOrNo.equals("y");
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_ROW; row++) {
            for (int col = 0; col < Constants.BOARD_COL; col++) {
                System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row,col)));
            }
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }

    public void printInvalidRowOrColumn() {
        System.out.printf(Constants.INVALID_ROW_OR_COLUMN);
    }

    public void printInvalidMove(int row, int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
    }

    public void printMove(State state, int row, int col) {
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()), row, col);
        System.out.println();
    } 

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getXName(), state.getOName()));
        System.out.println();
    }

    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }

}


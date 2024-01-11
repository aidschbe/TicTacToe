import java.util.*;

/**
 * Provides the playing field/board for the game via char array.
 * Author: hemmer
 * Date: 2022-12-06
 * Version: 0.2
 */

public class TicTacToe {

    public static char[][] board = new char[3][3]; // Creates a 3x3 char array

    /**
     * Initialises the board, filling the array with empty spaces.
     */
    public static void initBoard(){
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    /**
     * Prints the state of the board.
     */
    public static void printBoard(){
        for (int i = 0; i < board.length; i++) { // for loops, weil foreach loops in java keinen Zugriff auf die Index-# zulassen in meiner Konstellation (ohne müßigen extraaufwand wenns ein for loop auch tut :P
            for (int x = 0; x < board.length; x++) {
                System.out.print(" " + board[i][x]);
                if (x < board.length-1){
                    System.out.print(" |");
                } else System.out.println();
            }
            if (i < board.length-1) {
                System.out.println("---+---+---");
            }
        }
    }

    /**
     * Sets the players symbol in the corresponding array slot.
     * @param row Array row.
     * @param col Array column.
     * @param player Player symbol as char.
     * @return Returns true if placing was successful, false if slot is already taken.
     */
    public static boolean setPlay(int row, int col, char player){
        if (board[row][col] == ' '){
            board[row][col] = player;
            return true;
        } else return false;
    }

    /**
     * Checks win conditions.
     * @return Returns true if a player wins or in case of a stalemate, false otherwise.
     */
    public static boolean isGameOver() {

        // checks diagonal win conditions
        if (
                board[0][0] != ' ' &&
                        board[0][0] == board[1][1] &&
                        board[0][0] == board[2][2]
        ) {
            System.out.println("Player " + board[0][0] + " wins!");
            return true;
        } else if (
                board[0][2] != ' ' &&
                        board[0][2] == board[1][1] &&
                        board[0][2] == board[2][0]
        ) {
            System.out.println("Player " + board[0][2] + " wins!");
            return true;
        }

        // checks vertical and horizontal win conditions
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                if (
                        board[0][j] != ' ' &&
                                board[0][j] == board[1][j] &&
                                board[0][j] == board[2][j]
                ) {
                    System.out.println("Player " + board[0][j] + " wins!");
                    return true;
                }
            if (
                    board[i][0] != ' ' &&
                            board[i][0] == board[i][1] &&
                            board[i][0] == board[i][2]
            ) {
                System.out.println("Player " + board[i][i] + " wins!");
                return true;
            }
        }
        return false;
    }
}
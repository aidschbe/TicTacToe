import java.util.Scanner;

public class Main {

    /**
     * Generic method for accepting user input as int and returning it.
     * Catches IndexOutOfBoundsException.
     * @param InputText Text for the user input prompt.
     * @param boardArray Array representing the playing field.
     * @return Returns user input as int.
     */
    public static int gameInput(String InputText, char[][] boardArray){

        while(true){
            Scanner UserInput = new Scanner(System.in);
            System.out.print(InputText);
            try {
                int userChoice = UserInput.nextInt();
                char test = boardArray[userChoice][0]; // non-modular, unless both arrays have the same size
                return userChoice;
            }
            catch (IndexOutOfBoundsException e){
                System.err.println(e);
            }
        }
    }

    /**
     * Asks user input for the row they want to put their piece on.
     * @param boardArray Array representing the playing field.
     * @return Returns user input as int.
     */
    public static int getRow(char[][] boardArray){
        String rowInput = "Please input row: ";

        return gameInput(rowInput, boardArray);
    }

    /**
     * Asks user input for the column they want to put their piece on.
     * @param boardArray Array representing the playing field.
     * @return Returns user input as int.
     */
    public static int getColumn(char[][] boardArray){
        String colInput = "Please input column: ";

        return gameInput(colInput, boardArray);

    }

    /**
     * Checks turn number and returns player character.
     * @param turn Int value corresponding to turn number.
     * @return Returns character corresponding to the player ('x' or 'o').
     */
    public static char getPlayer(int turn) {
        if (turn % 2 == 0) return 'o';
        else return 'x';
    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();

        game.initBoard();

        game.printBoard();

        int turn = 1;

        while (true){

            if (turn > 9) {
                System.out.println("Stalemate!");
                break;
            }

            System.out.println("Turn " + turn + "!");

            if (game.setPlay(getRow(game.board), getColumn(game.board), getPlayer(turn)) == true) turn++;
            else System.out.println("Error: Field already taken.");

            game.printBoard();

            if (game.isGameOver() == true) break;
        }
    }
}
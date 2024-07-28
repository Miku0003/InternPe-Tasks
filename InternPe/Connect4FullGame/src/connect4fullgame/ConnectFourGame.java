package connect4fullgame;

import java.util.*;


public class ConnectFourGame {
    
    String[][] board;
    Boolean winner, draw;
    int winningPlayer, playerTurn;
    
    ConnectFourGame() {
    
        winningPlayer = 0;
        draw = false;
        playerTurn = 1;
        board = new String[6][7];
        newBoard();
        displayBoard();
        
    }
    
    private void newBoard() {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; i < 7; i++) {
                board[i][j] = " - ";
            }
        }
    }
    
    private void displayBoard() {
        System.out.println(" ");
        System.out.println("    *** CONNECT 4 FULL GAME ***");
        System.out.println(" ");
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * valid input
     * @param input from user
     * @return true is valid - false otherwise
     */
    
    private boolean validInput(String input) {
        return ((Objects.equals(input, "1")||
                Objects.equals(input, "2")||
                Objects.equals(input, "3")||
                Objects.equals(input, "4")||
                Objects.equals(input, "5")||
                Objects.equals(input, "6")||
                Objects.equals(input, "7")
            )
        );
    }
    
    /**
     * 
     * @param column
     * @return 
     */
    
    private boolean isColmnFull(int column) {
        
        return (board[0][column - 1] == " X " || board[0][column - 1] == " O ");
    
    }
    
    /**
     * 
     * @param column
     * @return 
     */
    
    private int getNextAvailableSlot(int column) {
        int position = 5;
        boolean found= false;
        while (position > 0 && !found) {
            if(!Objects.equals(board[position][column], "X") && !Objects.equals(board[position][column], "O")) {
                found = true;
            }else {
                position--;
            }
        }
        return position;
    }
    
    
    
    private void swapPlayerTurn() {
        if(playerTurn == 1) {
            playerTurn = 2;
        }else {
            playerTurn = 1;
        }
    }

    private void placePiece() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player" + playerTurn + "- Please select which column to place your piece(1-7) : ");
        String input = sc.nextLine();

        while(!validInput(input) || isColmnFull(Integer.parseInt(input))) {

            while(!validInput(input)){

                System.out.println("Invalid input - Please select a Column from 1-7");
                input = sc.nextLine();

            }

            while(isColmnFull(Integer.parseInt(input))) {

                System.out.println("Column Full, Choose Another Column");
                input = sc.nextLine();

                if(!validInput(input)) {
                    break;
                }

            }

        }
        int columnchoice = Integer.parseInt(input)-1;

        System.out.println("Next Available Row in Column : " + getNextAvailableSlot(columnchoice));

        String pieceToPlace;

        if(playerTurn == 1) {
            pieceToPlace = " X ";
        } else {
            pieceToPlace = " O ";
        }

        board[getNextAvailableSlot(columnchoice)][columnchoice] = pieceToPlace;
        displayBoard();
        swapPlayerTurn();

    }

    private boolean isBoardFull() {
        boolean full = true;
        for(int i=0;i<1;i++) {

            for(int j=0;j<7;j++) {

                if(board[i][j] != " X " && board[i][j] != " O ") {
                    full = false;
                }

            }

        }
        return full;
    }

    private String checkVerticalWinner() {
        String symbol = null;
        for(int i=0;i<6;i++) {

            for(int j=0;j<7;j++) {
                if((board[i][j] == board[i+1][j]) && (board[i][j] == board[i+2][j]) && (board[i][j] == board[i+3][j])) {
                    if(board[i][j] ==" X " | board[i][j] == " O ") {
                        symbol = board[i][j];
                    }
                }
            }

        }
        return symbol;
    }

    private String checkHorizontalWinner() {
        String symbol = null;
        for(int i=0;i<6;i++) {

            for(int j=0;j<7;j++) {
                if((board[i][j] == board[i][j+1]) && (board[i][j] == board[i][j+2]) && (board[i][j] == board[i][j+3])) {
                    if(board[i][j] ==" X " | board[i][j] == " O ") {
                        symbol = board[i][j];
                    }
                }
            }

        }
        return symbol;
    }

    private String checkLeftDiagonalWinner() {
        String symbol = null;
        for(int i=0;i<3;i++) {

            for(int j=0;j<4;j++) {
                if((board[i][j] == board[i+1][j+1]) && (board[i][j] == board[i+2][j+2]) && (board[i][j] == board[i+3][j+3])) {
                    if(board[i][j] ==" X " | board[i][j] == " O ") {
                        symbol = board[i][j];
                    }
                }
            }

        }
        return symbol;
    }

    private String checkRightDiagonalWinner() {
        String symbol = null;
        for(int i=0;i<3;i++) {

            for(int j=0;j<4;j++) {
                if((board[i][j] == board[i+1][j-1]) && (board[i][j] == board[i-2][j+2]) && (board[i][j] == board[i+3][j-3])) {
                    if(board[i][j] ==" X " | board[i][j] == " O ") {
                        symbol = board[i][j];
                    }
                }
            }

        }
        return symbol;
    }

    private int checkforWinner() {
        int winner = 0;
        String symbol = " ";

        if(checkVerticalWinner() == " X " || checkVerticalWinner() == " O ") {
            symbol = checkVerticalWinner();
        } else if(checkHorizontalWinner() == " X " || checkHorizontalWinner() == " O ") {
            symbol = checkHorizontalWinner();
        } else if(checkLeftDiagonalWinner() == " X " || checkLeftDiagonalWinner() == " O ") {
            symbol = checkLeftDiagonalWinner();
        } else if(checkRightDiagonalWinner() == " X " || checkRightDiagonalWinner() == " O ") {
            symbol = checkRightDiagonalWinner();
        }

        if(symbol ==" X ") {
            winner = 1;
        } else if(symbol == " O ") {
            winner = 2;
        }
        return winner;

    }

    private boolean checkforDraw() {
        return(isBoardFull() == true && (checkforWinner() != 1 && checkforWinner() != 2));
    } 

    private void showWinner() {

        System.out.println(" ");
        System.out.println("******************************");
        System.out.println("                              ");
        System.out.println("        PLAYER" + winningPlayer + "WINS!!!!!");
        System.out.println("    *                    *   ");
        System.out.println("        *   \\O/    *       ");
        System.out.println("    *   *   |   *   *       ");
        System.out.println("      *     / \\  *         ");
        System.out.println("````````````````````````````");
        System.out.println("****************************");

    }

    public void playGame() {
        while(winningPlayer == 0) {
            winningPlayer = checkforWinner();
            draw = checkforDraw();
            if(winningPlayer == 1) {
                showWinner();
                break;
            }else if(winningPlayer == 2){
                showWinner();
                break;
            } else if(draw == true) {
                System.out.println("It's a draw");
                break;
            }
            placePiece();
        }
    }


    
    /**
     * 
     * @param args 
     */
    
    public static void main(String args[]) {
        
        new ConnectFourGame();
        
    }
    
}

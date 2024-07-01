import java.util.*;

public class NumberGuessingGame{

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);
        String play = "yes";

        while(play.equals("yes")){

            //while loop to determineif we are going to play the game again
            Random rand = new Random();
            int randNum = rand.nextInt(100);
            int guess = -1;
            int tries = 0;

            //while loop to check if the game is over
            while(guess != randNum) {
                System.out.print("Guess a number netween 1 and 100 ");
                guess= reader.nextInt();
                tries++;

                if(guess == randNum){

                    System.out.println("Awesome! You guessed the numer!");
                    System.out.println("It only took you " + tries + " guess!");
                    System.out.println("Would you like to play again? Yes or No: ");
                    play = reader.next().toLowerCase();

                } else if(guess > randNum) {
                    System.out.println("Yur guess is too high, try again.");
                } else {
                    System.out.println("Yur guess is too low, try again.");
                }
            }

        }
        reader.close();
    }

}
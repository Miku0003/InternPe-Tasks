import java.util.*;

public class RockPaperScissorGame {

    RockPaperScissorGame() {
        String[] rockPaperScissor = {"Rock", "Paper", "Scissor"};
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while(true) {

            System.out.println("Enter move (Rock, Paper, Scissior). To Exit The Game, Type\"Exit\": ");
            String userMove = sc.nextLine();

            if(userMove.equalsIgnoreCase("Exit")) {
                break;
            }

            if(!userMove.equalsIgnoreCase("Rock") && !userMove.equalsIgnoreCase("Paper") && !userMove.equalsIgnoreCase("Scissor")) {

                System.out.println("Invalid Item, Please Try Again.");
                continue;
            }

            int moveIndex = rand.nextInt(3);
            String move = rockPaperScissor[moveIndex];

            System.out.println("Item: " + move);

            if(userMove.equalsIgnoreCase(move)) {

                System.out.println("You Win!");
 
            } else {

                System.out.println("You Lose!");
            
            }

        }
    }

    public static void main(String args[]) {
        new RockPaperScissorGame();
    }

}
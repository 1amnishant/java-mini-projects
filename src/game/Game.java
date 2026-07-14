package game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String [] args){

        String playerChoice;
        String computerChoice;
        String playAgain = "y";
        String [] choice= {"rock", "paper", "scissor"};
        int playerScore=0;
        int computerScore=0;
        int i = 1;

        System.out.println("WELCOME TO THE GAME\n");
        System.out.println("Chose between(rock,paper,scissor) ");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.println("Round  "+i);
            System.out.print("Your Chose      : ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock")
                    && !playerChoice.equals("paper")
                    && !playerChoice.equals("scissor")) {
                System.out.println("INVALID CHOICE!");
                continue;
            }

            computerChoice = choice[random.nextInt(3)];
            System.out.println("Computer Chose : " + computerChoice);
            i++;
            System.out.println("----------------------------------");


            if (playerChoice.equals("rock") && computerChoice.equals("scissor")
                    || playerChoice.equals("paper") && computerChoice.equals("rock")
                    || playerChoice.equals("scissor") && computerChoice.equals("paper")) {

                System.out.println("YOU WIN!");
                playerScore++;
            } else if (playerChoice.equals(computerChoice)) {

                System.out.println("IT'S A TIE!");
            } else {

                System.out.println("YOU LOSE!");
                computerScore++;
            }

            System.out.println("Player       :"+playerScore);
            System.out.println("Computer     :"+computerScore);
            System.out.println("----------------------------------");

            do{
                System.out.print("Do you want to play again(y/n): ");
                playAgain= scanner.nextLine().toLowerCase();

                if(!playAgain.equals("y") && !playAgain.equals("n")){
                    System.out.print("Invalid Input! Please enter y/n");
                }
            }while(!playAgain.equals("y") && !playAgain.equals("n"));
        }while(playAgain.equals("y"));
        System.out.println("\nFinal score\n" );
        System.out.println("Player       :"+playerScore);
        System.out.println("Computer     :"+computerScore);

        if(playerScore>computerScore){
            System.out.println("\nWinner:  Player\n");
        }
        else if((playerScore == computerScore)){
            System.out.println("\nWinner:  None\n");
        }
        else{
            System.out.println("\nWinner:  Computer\n");
        }

        System.out.println("\nTHANKS FOR PLAYING");
        scanner.close();
    }
}

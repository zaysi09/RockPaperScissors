import java.util.*;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\nLet's play rock, paper and scissors. How many rounds? ");
            int rounds = sc.nextInt(); sc.nextLine();
            int userWins = 0, pcWins = 0;
            for (int i = 0; i < rounds; i++) {
                System.out.println((i == 0) ? "Rock, Paper, or Scissors?" : "Go again!");
                String userInput;
                do {
                    System.out.print("\nYou: ");
                    userInput = sc.next().toLowerCase();
                    if (!(userInput.equalsIgnoreCase("rock") ||
                        userInput.equalsIgnoreCase("paper") ||
                        userInput.equalsIgnoreCase("scissors"))) {
                        System.out.println("Invalid input. Try again.");
                    }
                } while (!(userInput.equalsIgnoreCase("rock") ||
                        userInput.equalsIgnoreCase("paper") ||
                        userInput.equalsIgnoreCase("scissors")));
                int result = resultCalculation(userInput);
                if (result == 1) userWins++;
                else if (result == -1) pcWins++;
            }
            publishResult(userWins, pcWins);
            System.out.println("Do you wanna play again? (y/n)");
            char decision = sc.next().toLowerCase().charAt(0);
            flag = (decision == 'y');
        }
        sc.close();
    }

    static int resultCalculation(String word){
        String set [] = {"rock", "paper", "scissors"};
        Random rn = new Random();
        String pcAns = set[rn.nextInt(3)];
        System.out.println("Computer: " + pcAns.toUpperCase());
        if ((word.equals("rock") && pcAns.equals("scissors")) ||
            (word.equals("scissors") && pcAns.equals("paper")) ||
            (word.equals("paper") && pcAns.equals("rock"))) {
                System.out.println("Win");
                return 1;
        }
        else if (word.equals(pcAns)) {
            System.out.println("Tie");
            return 0;
        }
        else {
            System.out.println("Loss");
            return -1;
        }
    }

    static void publishResult (int userWins, int pcWins){
        if (userWins == pcWins) System.out.println("It's a tie! " + userWins + "-" + pcWins);
        else if (userWins > pcWins) System.out.println("Congratulations! You win " + userWins + "-" + pcWins);
        else System.out.println("Sorry! You lose " + userWins + "-" + pcWins);
    }
}
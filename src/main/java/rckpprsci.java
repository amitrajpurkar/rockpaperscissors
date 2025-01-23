import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class rckpprsci {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static Map<String, Integer> score;

    public static void main(String[] args) {
        playRockPaperScissors();
    }

    public static void playRockPaperScissors() {
        resetScore();
        boolean exit_entered = Boolean.FALSE;
        try (Scanner kbReader = new Scanner(System.in)) {
            do {
                System.out.println("enter your number: 1.rock, 2.paper, 3.scissor (or 'exit' to quit): ");
                String usersChoice = kbReader.next();
                if (usersChoice.equalsIgnoreCase("exit")) {
                    exit_entered = Boolean.TRUE;
                    break;
                }
                int userChoice = Integer.parseInt(usersChoice);
                int computerChoice = getComputerChoice();

                // score calculation
                trackScore(userChoice, computerChoice);
                displayChoices(userChoice, computerChoice);
            } while (!exit_entered);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(
            "Final Results -- user wins "+score.get("user_wins")
            + " times, computer wins "+score.get("computer_wins")
            + " times, and draws "+score.get("draws")+" times"
            );
    }

    private static void displayChoices(int userChoice, int computerChoice) {
        String uVal, cVal;
        if (userChoice == ROCK) {
            uVal = "rock";
        } else if (userChoice == PAPER) {
            uVal = "paper";
        } else {
            uVal = "scissors";
        }
        if (computerChoice == ROCK) {
            cVal = "rock";
        } else if (computerChoice == PAPER) {
            cVal = "paper";
        } else {
            cVal = "scissors";
        }
        System.out.println("userChoice: " + uVal + ", computerChoice: " + cVal);
    }

    private static int getComputerChoice() {
        return (int) (Math.random() * 3) + 1;
    }   

    private static void resetScore() {
        score = new HashMap<>();
        score.put("user_wins", 0);
        score.put("computer_wins", 0);
        score.put("draws", 0);
    }

    private static void trackScore(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            score.put("draws", score.get("draws") + 1);
        } else if ((userChoice == ROCK && computerChoice == SCISSORS)
                || (userChoice == PAPER && computerChoice == ROCK)
                || (userChoice == SCISSORS && computerChoice == PAPER)) {
            score.put("user_wins", score.get("user_wins") + 1);
        } else if ((userChoice == SCISSORS && computerChoice == ROCK)
                || (userChoice == ROCK && computerChoice == PAPER)
                || (userChoice == PAPER && computerChoice == SCISSORS)) {
            score.put("computer_wins", score.get("computer_wins") + 1);
        }
    }

    
}
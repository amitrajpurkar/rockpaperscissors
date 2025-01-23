import java.util.Scanner;

public class PlayCli {
    public static void main(String[] args) {
        try (Scanner kbReader = new Scanner(System.in)) {
            System.out.println("which game would you like to play? ");
            System.out.println("Enter 1. for Rock Paper Scissors and 2. for Weather: ");
            String game = kbReader.next();
            switch (game) {
                case "1" -> rckpprsci.playRockPaperScissors();
                case "2" -> weather.askZipShowWeather();
                default -> System.out.println("Invalid game choice.");
            }
        }
    }
}

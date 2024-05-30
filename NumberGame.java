package coding1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";
        int rounds = 0;
        int totalAttempts = 0;

        while (playAgain.equalsIgnoreCase("y")) {
            rounds++;
            int attempts = playGame(scanner);
            totalAttempts += attempts;
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        if (rounds > 0) {
            double averageAttempts = (double) totalAttempts / rounds;
            System.out.printf("Game over! You played %d rounds with an average of %.2f attempts per round.%n", rounds, averageAttempts);
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int low = 1;
        int high = 100;
        int number = random.nextInt(high - low + 1) + low;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.printf("Guess the number between %d and %d. You have %d attempts.%n", low, high, maxAttempts);

        while (attempts < maxAttempts) {
            System.out.printf("Attempt %d: Enter your guess: ", attempts + 1);
            int guess;

            try {
                guess = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            attempts++;

            if (guess < low || guess > high) {
                System.out.printf("Please enter a number between %d and %d.%n", low, high);
            } else if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.printf("Congratulations! You've guessed the correct number %d in %d attempts.%n", number, attempts);
                return attempts;
            }
        }

        System.out.printf("Sorry, you've used all %d attempts. The correct number was %d.%n", maxAttempts, number);
        return attempts;
    }
}

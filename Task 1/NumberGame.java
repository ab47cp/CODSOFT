import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Random rad = new Random();
        
        int maxAttempt = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("\nWelcome to the Number Guessing Game!");
        System.out.print("Enter the Minimum Range: ");
        int minRange = sc.nextInt();
        System.out.print("Enter the Maximum Range: ");
        int maxRange = sc.nextInt();

        while (playAgain) {
            int target = rad.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nA number has been generated between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempt + " attempts to guess the number.");
            int attempts = 0;

            while (attempts < maxAttempt) {
                System.out.println("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("Congratulations! You guessed the number correctly. ");
                    score += maxAttempt - attempts + 1;
                    break;
                } 
                else if (guess < target) 
                    System.out.println("Too low! Try again.");
                else
                    System.out.println("Too high! Try again.");

                if (attempts == maxAttempt)
                    System.out.println("\nSorry, No more attempts left. The number was: " + target);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String Response = sc.next();
            playAgain = Response.equalsIgnoreCase("yes");
        }

        System.out.println("Your score: " + score);
        sc.close();
    }
}

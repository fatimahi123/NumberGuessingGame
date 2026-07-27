import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(1001); // 0–1000
        int guessesleft = 10;
        int warnings = 0;
        ArrayList<Integer> guessednums = new ArrayList<>();
        System.out.println("Welcome to Number Guessing Game.");
        System.out.println("Guess a number between 0 and 1000");
        System.out.println("You have 10 guesses.\n");
        while (guessesleft > 0)
        {
            System.out.println("Guesses left: " + guessesleft);
            System.out.println("Guessed so far: " + guessednums);
            System.out.print("Enter your guess: ");
            String input = sc.nextLine();
            boolean isvalid = true;
            for (int i = 0; i < input.length(); i++)
            {
                if (!Character.isDigit(input.charAt(i))) {
                    isvalid = false;
                    break;
                }
            }
            if (!isvalid || input.isEmpty())
            {
                warnings++;
                System.out.println("Invalid input! Enter numbers only.");

                if (warnings >= 2)
                {
                    guessesleft--;
                    System.out.println("You lost a guess due to repeated invalid input!");
                }
                continue;
            }
            int guess = Integer.parseInt(input);
            if (guess < 0 || guess > 1000)
            {
                warnings++;
                System.out.println("Out of range! Enter between 0–1000.");

                if (warnings >= 2)
                {
                    guessesleft--;
                    System.out.println("You lost a guess due to repeated invalid input!");
                }
                continue;
            }
            if (guessednums.contains(guess))
            {
                warnings++;
                System.out.println("You already guessed this number!");

                if (warnings >= 2) {
                    guessesleft--;
                    System.out.println("You lost a guess due to repeated mistake!");
                }
                continue;
            }
            warnings = 0;
            guessednums.add(guess);
            guessesleft--;
            if (guess == number) {
                System.out.println("Correct! You won.");
                return;
            } else if (guess > number) {
                System.out.println("Your guess is bigger.\n");
            } else {
                System.out.println("Your guess is smaller.\n");
            }
        }

        System.out.println("You lost.The number was: " + number);
    }
}
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static Scanner scanner = new Scanner(System.in);
    private static final int MAX_GUESSES = 6;
    private int incorrectGuesses = MAX_GUESSES;

    private String chosenWord;
    static Set<Character> guessedLetters = new HashSet<>();
    static Set<Character> incorrectLetters = new HashSet<>();

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        hangman.chooseRandomWord();

        while (!hangman.isWordFullyGuessed() && hangman.incorrectGuesses > 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("Enter a character: ");
            char userInput = scanner.next().toLowerCase().charAt(0);
            if (Character.isLetter(userInput)) {
                hangman.updateGameState(userInput);
                System.out.println("Guessed Letters: " + guessedLetters);
                hangman.displayCurrentState();
            } else {
                System.out.println("Please enter a valid letter.");
            }
        }

        if (hangman.isWordFullyGuessed()) {
            System.out.println("Congratulations! You've guessed the word.");
        } else {
            System.out.println("Sorry! You're out of guesses. The word was " + hangman.chosenWord + ".");
        }
    }

    public void chooseRandomWord() {
        Random rand = new Random();
        String[] words = {"apple", "banana", "cherry", "future", "camera", "government", "marshmallow", "reflection"};
        chosenWord = words[rand.nextInt(words.length)];
    }

    public void displayCurrentState() {
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < chosenWord.length(); i++) {
            if (guessedLetters.contains(chosenWord.charAt(i))) {
                word.append(chosenWord.charAt(i));
            } else {
                word.append('_');
            }
            word.append(' ');
        }

        System.out.println(word);
    }

    public void updateGameState(char letter) {
        if (guessedLetters.contains(letter) || incorrectLetters.contains(letter)) {
            System.out.println("Letter already guessed. Try a different one.");
        } else if (chosenWord.indexOf(letter) >= 0) {
            guessedLetters.add(letter);
        } else {
            incorrectGuesses--;
            incorrectLetters.add(letter);
            System.out.println("Incorrect! You have " + incorrectGuesses + " guesses left.");
        }
    }

    public boolean isWordFullyGuessed() {
        for (int i = 0; i < chosenWord.length(); i++) {
            if (!guessedLetters.contains(chosenWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}


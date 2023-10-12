import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (isPalindrome(text)) {
            System.out.println("The entered text is a palindrome.");
        } else {
            System.out.println("The entered text is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        text = text.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

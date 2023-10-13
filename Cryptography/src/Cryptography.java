import java.util.Scanner;

public class Cryptography {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        System.out.println("Enter the shift (number of positions):");
        int shift = scanner.nextInt();

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                String encryptedText = encrypt(text, shift);
                System.out.println("Encrypted text: " + encryptedText);
                break;
            case 2:
                String decryptedText = decrypt(text, shift);
                System.out.println("Decrypted text: " + decryptedText);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encrypted.append((char) ((character + shift - base) % 26 + base));
            } else {
                encrypted.append(character);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}

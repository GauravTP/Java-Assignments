import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args){
        System.out.println("Enter your string");
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String words[] =text.split("\\s");
        int length = words.length;

        System.out.println("Number of words are:"+ length);


    }
}

import java.util.Scanner;


public class HelloWorld {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter Your Name: ");
        String greeting_name;

        String name = scanner.nextLine();
        if (!Character.isUpperCase(name.charAt(0))) {
            System.out.println("Capitalising the first letter!");
            String sub_name = name.substring(0, 1).toUpperCase();
            greeting_name = sub_name + name.substring(1);
        } else {
            greeting_name = name;
        }
        System.out.println("Hello, " + greeting_name + "!");
    }
}

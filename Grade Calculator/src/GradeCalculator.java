import java.util.Arrays;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true){
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Score");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter the number of scores for " + name + ": ");
                    int numScores = scanner.nextInt();

                    int[] scores = new int[numScores];

                    for (int i=0; i< numScores; i++){
                        int score;
                        do {
                            System.out.print("Enter score for subject " + (i + 1) + " (0-100): ");
                            score = scanner.nextInt();
                            if (score < 0 || score > 100) {
                                System.out.println("Invalid input! Please enter a score between 0 and 100.");
                            }
                        } while (score < 0 || score > 100);
                        scores[i] = score;
                    }
                    System.out.println(Arrays.toString(scores));
                    Student newStudent = new Student(scores, name);
                    manager.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter Student's Name to update scores: ");
                    String searchName = scanner.next();
                    Student studentToUpdate = manager.findStudentByName(searchName);
                    if (studentToUpdate != null) {
                        System.out.print("Enter the number of new scores for " + searchName + ": ");
                        int numOfScores = scanner.nextInt();

                        int[] newScores = new int[numOfScores];

                        for (int i = 0; i < numOfScores; i++) {
                            int score;
                            do {
                                System.out.print("Enter new score for subject " + (i + 1) + " (0-100): ");
                                score = scanner.nextInt();
                                if (score < 0 || score > 100) {
                                    System.out.println("Invalid input! Please enter a score between 0 and 100.");
                                }
                            } while (score < 0 || score > 100);
                            newScores[i] = score;
                        }
                        studentToUpdate.setScore(newScores);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    manager.displayResults();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please choose a valid option.");
                    break;
            }
        }
    }
}

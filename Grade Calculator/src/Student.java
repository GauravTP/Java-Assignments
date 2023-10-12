import java.util.Arrays;

public class Student {
    private String name;
    private int[] scores;
    private char grade;

    public Student(int[] scores, String name) {
        this.name = name;
        this.scores = scores;
        this.grade = getGrade(scores);
    }

    public char getGrade(int[] scores) {
        int averageScore = Arrays.stream(scores).sum() / scores.length ;

        if (averageScore >= 80) {
            grade = 'A';
        } else if (averageScore >= 60 && averageScore < 80) {
            grade = 'B';
        } else if (averageScore >= 40 && averageScore < 60) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        return grade;
    }

    public void setScore(int[] scores) {
        this.scores = scores;
        this.grade = getGrade(scores);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student [Name=" + name + ", Total Score=" + Arrays.stream(scores).sum() + ", Grade Received=" + grade + "]";
    }

}

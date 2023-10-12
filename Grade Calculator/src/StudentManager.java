import java.util.ArrayList;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

     public void addStudent(Student student){
         students.add(student);
     }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

     public void displayResults(){
        for (Student student: students){
            System.out.println(student);
        }
     }
}

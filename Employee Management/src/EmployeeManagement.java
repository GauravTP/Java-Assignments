import java.util.Scanner;

//public class EmployeeManagement {
//    public static void main(String[] args) {
//        EmployeeManager manager = new EmployeeManager();
//
//        Employee emp1 = new Employee(1, "Pankaj", 50000);
//        Employee emp2 = new Employee(2, "Raj", 55000);
//
//        manager.addEmployee(emp1);
//        manager.addEmployee(emp2);
//
//        manager.listEmployees();
//        System.out.println("--------------------------------------------------------------");
//
//        manager.updateEmployee(2, "Raj Shekar", 60000);
//        manager.listEmployees();
//
//        System.out.println("--------------------------------------------------------------");
//
//        manager.deleteEmployee(1);
//        manager.listEmployees();
//    }
//}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextFloat();
                    Employee employee = new Employee(id, name, salary);
                    manager.addEmployee(employee);
                    break;
                case 2:
                    System.out.print("Enter of the employee to update: ");
                    int updatedId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String updatedName = scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    double updatedSalary = scanner.nextFloat();
                    manager.updateEmployee(updatedId, updatedName, updatedSalary);
                    break;
                case 3:
                    System.out.print("Enter of the employee to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteEmployee(deleteId);
                    break;
                case 4:
                    manager.listEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
//                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
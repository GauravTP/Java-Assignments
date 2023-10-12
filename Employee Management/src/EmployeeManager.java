import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        if(employeeMap.containsKey(employee.getId())) {
            System.out.println("Employee with this ID already exists.");
        } else {
            employeeMap.put(employee.getId(), employee);
            System.out.println(employee.getName()+" added to the System.");
        }
    }

    public void updateEmployee(int id, String name, double salary) {
        if(employeeMap.containsKey(id)) {
            Employee employee = employeeMap.get(id);
            employee.setName(name);
            employee.setSalary(salary);
            System.out.println(employee.getName()+"'s details updated successfully.");
        } else {
            System.out.println("Employee with this ID does not exist.");
        }
    }

    public void deleteEmployee(int id) {
        if(employeeMap.containsKey(id)) {
             Employee employee_obj = employeeMap.get(id);
            employeeMap.remove(id);
            System.out.println(employee_obj.getName()+" removed successfully.");
        } else {
            System.out.println("Employee with this ID does not exist.");
        }
    }

    public void listEmployees() {
        for(Employee employee : employeeMap.values()) {
            System.out.println(employee);
        }
    }
}

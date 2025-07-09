import java.util.*;

public class EmployeeCRUD {

    private List<Employee> employeeList = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee e) {
        employeeList.add(e);
        System.out.println("Employee added: " + e);
    }

    // READ
    public void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    // UPDATE
    public void updateEmployee(int id, String newName, String newDepartment) {
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                e.setName(newName);
                e.setDepartment(newDepartment);
                System.out.println("Employee updated: " + e);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // DELETE
    public void deleteEmployee(int id) {
        Iterator<Employee> it = employeeList.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == id) {
                it.remove();
                System.out.println("Employee removed: " + e);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Harsha", "IT"));
        crud.addEmployee(new Employee(2, "Revanth", "HR"));

        // Read
        crud.viewEmployees();

        // Update
        crud.updateEmployee(1, "Harsha Vardhan", "Finance");

        // Read again
        crud.viewEmployees();

        // Delete
        crud.deleteEmployee(2);

        // Final list
        crud.viewEmployees();
    }
}

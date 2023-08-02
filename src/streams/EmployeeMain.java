package streams;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Employee[] employees =  {
			new Employee(111, "Employee 1", 5000, "Dept A"),
			new Employee(112, "Employee 2", 4500, "Dept B"),
			new Employee(113, "Employee 3", 8700, "Dept D"),
			new Employee(114, "Employee 4", 7100, "Dept C"),
			new Employee(115, "Employee 5", 1900, "Dept A"),
			new Employee(116, "Employee 6", 6600, "Dept D"),
			new Employee(117, "Employee 7", 7100, "Dept D"),
			new Employee(118, "Employee 8", 7600, "Dept B"),
			new Employee(119, "Employee 9", 9100, "Dept C"),
			new Employee(110, "Employee 10", 4300, "Dept A")
		};
		
		List<Employee> list = Arrays.asList(employees);
		list.stream().filter(employee -> employee.getSalary() > 5000)
		.forEach(employee -> System.out.println(employee.getName()));
	}

}

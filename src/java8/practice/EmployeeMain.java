package java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Employee[] employees =  {
			new Employee(111, "Fischer", 5000, "Dept A"),
			new Employee(112, "Tal", 4500, "Dept B"),
			new Employee(113, "Petrosian", 8700, "Dept D"),
			new Employee(114, "Topalov", 7100, "Dept C"),
			new Employee(115, "Kasparov", 1900, "Dept A"),
			new Employee(116, "Anand", 6600, "Dept D"),
			new Employee(117, "Karpov", 7100, "Dept D"),
			new Employee(118, "Carlsen", 7600, "Dept B"),
			new Employee(119, "Polgar", 9100, "Dept C"),
			new Employee(110, "Capablanca", 4300, "Dept A")
		};
		
		// Print Employees with salary GT 5000
		System.out.println("================================================");
		List<Employee> list = Arrays.asList(employees);
		list.stream().filter(employee -> employee.getSalary() > 5000)
		.forEach(employee -> System.out.println(employee.getName()));
		
		//Group Employees based on Department
		System.out.println("==========Group Employees based on Department================");
		Map<String, List<Employee>> employeeGroup = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDept()));		
		employeeGroup.forEach((Dept, Names) -> System.out.println("Department->"+Dept+" Employees->"+Names.toString()));
		
		//Change All Dept D to Dept Z
		System.out.println("================================================");
		list.stream().filter(emp -> emp.getDept().equals("Dept A")).map(emp ->{
			emp.setDept("Dept Z");
			return emp;
		}).collect(Collectors.toList()).forEach(System.out::println);
		
		//Without filtering
		System.out.println("================================================");
		list.stream().map(emp ->{
			if("Dept A".equals(emp.getDept())) {
				emp.setDept("Dept Z");
			}
			return emp;
		}).collect(Collectors.toList()).forEach(System.out::println);
		
		//Filter out the employees start with some letter
		System.out.println("================================================");
		list.stream().filter(emp -> emp.getName().startsWith("C"))
		.collect(Collectors.toList()).forEach(System.out::println);
		
		// Average salary for each department
		System.out.println("================================================");
		Double avgSalary = list.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble();
		System.out.println("Average salary->"+avgSalary);
		
	}

}

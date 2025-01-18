package cache.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cache.model.Employee;
import cache.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Cacheable("employeesCache") // Specify the cache name
	public List<Employee> getEmployees() {
		// Simulated expensive API call or database query
		// Fetch employees from the source
		//List<Employee> employees1 = employeeRepository.findAll();
		List<Employee> employees = fetchEmployeesFromSource();
		
		return employees;
	}

	private List<Employee> fetchEmployeesFromSource() {
		// Simulated implementation for fetching employees from source
		// This method will be invoked only if the cache is empty or invalidated
		// Replace it with your actual implementation
		// ...
		System.out.println("employees are fetched from resource");
		List<Employee> employees = Arrays.asList(new Employee(1L, "sri"), new Employee(2L, "ram"),
				new Employee(3L, "raj"));
		return employees;
	}
}
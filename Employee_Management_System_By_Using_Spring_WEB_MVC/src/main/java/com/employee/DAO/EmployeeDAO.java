package com.employee.DAO;

import java.util.List;
import java.util.Optional;

import com.employee.entity.EmployeeDetails;

public interface EmployeeDAO {
	
	EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails);
	
	List<EmployeeDetails> getAllEmployeeDetails();
	
	boolean deleteEmployeeByUsingId(int id);

	Optional<EmployeeDetails> findByEmployeeId(int id);
	
	EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails);

	

}

package com.employee.DAO;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.Repository.EmployeeRepository;
import com.employee.entity.EmployeeDetails;
@Component
public class EmployeeDAOImple implements EmployeeDAO {


	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeDetails); 
		
	}
	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		
		return employeeRepository.findAll();
		
	}
	@Override
	public boolean deleteEmployeeByUsingId(int id) {
		
//		employeeRepository.deleteById(id);
		 Optional<EmployeeDetails> findById = employeeRepository.findById(id);
		 try {
			EmployeeDetails employeeDetails = findById.get();
			employeeRepository.delete(employeeDetails);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	@Override
	public Optional<EmployeeDetails> findByEmployeeId(int id) {
		// TODO Auto-generated method stub
		
		return employeeRepository.findById(id);
	}
	@Override
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeDetails);
	}
	


}

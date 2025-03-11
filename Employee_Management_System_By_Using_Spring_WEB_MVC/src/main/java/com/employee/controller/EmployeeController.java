package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.DAO.EmployeeDAO;
import com.employee.entity.EmployeeDetails;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	/*ALL Employee Related Request
	 * Registration
	 * Login
	 * UpDation
	 * Deletion*/
//	@RequestMapping("/empregistration")
//	public void employeeRegistration(@RequestParam("empname") String name,
//			@RequestParam("empemailid") String emailid,
//			@RequestParam("emppassword") String password,
//			@RequestParam("empsalary")  double salary,
//			@RequestParam("empdeptno") int deptno) {
//		
//		System.out.println("Employee Name :"+name);
//		System.out.println("Employee Emailid :"+emailid);
//		System.out.println("Employee Password :"+password);
//		System.out.println("Employee Salary :"+salary);
//		System.out.println("Employee Deptno :"+deptno);
//		System.out.println("Registration Successfull");
//	}
	@RequestMapping("/empregistration")
	public String employeeRegsitration(EmployeeDetails employeeDetails) {
		EmployeeDetails details = employeeDAO.insertEmployeeDetails(employeeDetails);
		if (details!=null) {
//			return "<center><h2>Data Inserted</h2></center>";
			return "redirect:/teca34/allemployeedetails";
		} else {
//			return "<center><h2>Invalid Data</h2></center>";
			return "redirect:/teca34/registrationpage"; 
		}
		
	}
	@RequestMapping("/emplogin")
	@ResponseBody
	public String employeeLogin() {
		System.out.println("Employee Login Successfull");
		return "Employee Login Successfull";
	}
	@RequestMapping("/registrationpage")
	public String employeeRegistrationPage()
	{
		return "EmployeeRegistration";
	}
	
	@RequestMapping("/allemployeedetails")
	//@ResponseBody
	public String allEmployeeDetails(Model model)			//Model is an interface which is used to print the data on another frontend page. 
	{
		List<EmployeeDetails> allEmployeeDetails = employeeDAO.getAllEmployeeDetails();
		model.addAttribute("listOfAllEmployeeDetails", allEmployeeDetails);
		return "AllEmployeeDetails";
		//return employeeDAO.getAllEmployeeDetails()+"";
		
	}
	
	@RequestMapping("/detailsbyid")
	public String deleteEmployeeByUsingId(int id) {
		System.out.println(id);
		if (employeeDAO.deleteEmployeeByUsingId(id)) {
			return"redirect:/teca34/allemployeedetails";
		}
		else {
			return"";
		}
	}
	@RequestMapping("/update")
	public String updateEmployee(int id, Model model) {
		Optional<EmployeeDetails> findByEmployeeId = employeeDAO.findByEmployeeId(id);
		EmployeeDetails employeeDetails = findByEmployeeId.get();
		model.addAttribute("update", employeeDetails);
		return "UpdateEmployee";
	}
	@RequestMapping("/updateddetails")
	public void updatedEmployeeDetails(EmployeeDetails employeeDetails) {
		System.out.println(employeeDetails);
		EmployeeDetails details = employeeDAO.updateEmployeeDetails(employeeDetails);
		System.out.println(details);
		
	}
}

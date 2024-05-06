package com.siddhesh.fullStack.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhesh.fullStack.exception.UserNotFoundException;
import com.siddhesh.fullStack.model.Employee;
import com.siddhesh.fullStack.repo.EmployeeRepo;

@Service
public class EmployeeService 
{
	private EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees()
	{
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(long id)
	{
		employeeRepo.deleteById(id);
	}
	
	public Employee findEmployeeById(long id)
	{
		return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by ID "+ id + " was not found"));
	}

}

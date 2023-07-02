package com.cab.service;

import java.util.List;

import com.cab.dto.EmployeeDTO;
import com.cab.entity.Employee;
import com.cab.exception.EmployeeException;

public interface EmployeeService {

	public EmployeeDTO getEmployee(Integer id) throws EmployeeException;
	
	public Employee getEmployee2(Integer id) throws EmployeeException;
	
	public List<EmployeeDTO> getAllEmployees()throws EmployeeException;
	
	public void addEmployee(EmployeeDTO empdto)throws EmployeeException;
	
	public void deleteEmployee(Integer id)throws EmployeeException;
	
	public void updateEmployee(Integer id,EmployeeDTO emp)throws EmployeeException;
	
	public EmployeeDTO getByName(String name)throws EmployeeException;
	
	public EmployeeDTO getByPhoneNumber(Long phoneNo)throws EmployeeException;
	
	
	
}

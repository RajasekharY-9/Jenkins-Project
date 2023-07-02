package com.cab.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.dto.EmployeeDTO;
import com.cab.entity.Employee;
import com.cab.exception.EmployeeException;
import com.cab.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@Validated
@RequestMapping("api")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Environment env;
	

	//
	@GetMapping("emp/get/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) throws EmployeeException{
		EmployeeDTO emp=employeeService.getEmployee(id);
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
		
		
	}
	
	public Employee getEmployee2(@PathVariable Integer id) throws EmployeeException{
		
		
		
		
		return null;
		
	}
	@GetMapping("emp/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees()throws EmployeeException{
		
		List<EmployeeDTO> em=employeeService.getAllEmployees();
		
		
		return new ResponseEntity<>(em,HttpStatus.OK);
		
	}
	
	@PostMapping("/emp/add")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid EmployeeDTO empdto)throws EmployeeException{
		
		employeeService.addEmployee(empdto);
		String msg=env.getProperty("API_SUCCESS");
		
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/emp/del/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)throws EmployeeException{
		
		employeeService.deleteEmployee(id);
String msg=env.getProperty("API_DELETED");
		
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/emp/{id}/upd")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDTO emp)throws EmployeeException{
		employeeService.updateEmployee(id, emp);
String msg=env.getProperty("API_UPDATED");
		
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/emp/name/{name}")
	public ResponseEntity<EmployeeDTO> getByName(@PathVariable String name)throws EmployeeException{
		
		EmployeeDTO e=employeeService.getByName(name);
		
		return new ResponseEntity<>(e,HttpStatus.OK);
		
	}
	//http://localhost:8089/api/employees/phoneNo/6078879890
	@GetMapping("/employees/phoneNo/{phoneNo}")
	public ResponseEntity<EmployeeDTO> getByPhoneNumber(@PathVariable("phoneNo") Long phoneNo) throws EmployeeException {
	    
		EmployeeDTO e = employeeService.getByPhoneNumber(phoneNo);
	        return ResponseEntity.ok(e);
	    
	}

	
	
	
	

}

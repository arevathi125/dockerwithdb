package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
   
	@Autowired
	EmployeeRepo repo;
	
	//insert 
	public Employee insert(Employee e) {
		return repo.save(e);
	}
	
	//retrive
	public List<Employee> getAll(){
	return repo.findAll();
	}

	
	//update
	public Employee update(Employee e) {
		Employee employee = repo.findById(e.getEmp_No()).orElse(null);
		employee.setEmp_Name(e.getEmp_Name());
		employee.setEmp_Phone(e.getEmp_Phone());
		return repo.save(employee);
	}
	
	//delete
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}

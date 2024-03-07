package com.rudraksh.EC2RDScruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudraksh.EC2RDScruddemo.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

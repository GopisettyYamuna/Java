package com.employee.springbootrestfulapihibernatepostgresql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{
    
}

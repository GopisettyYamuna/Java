package com.employee.springbootrestfulapihibernatepostgresql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class EmployeeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @Column(name = "name")
    public String name;

    @Column(name = "location")
    public String location;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeeId, String name, String location) {
        this.employeeId = employeeId;
        this.name = name;
        this.location = location;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", location=" + location + "]";
    }

    





    

}

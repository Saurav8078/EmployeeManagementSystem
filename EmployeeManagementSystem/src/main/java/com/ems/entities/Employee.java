package com.ems.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "name")
    private String name;

    // Many employees belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    // Setter for department
    // This setter establishes the relationship between Employee and Department entities

    public void setDepartment(Department department) {
        this.department = department;
    }
}

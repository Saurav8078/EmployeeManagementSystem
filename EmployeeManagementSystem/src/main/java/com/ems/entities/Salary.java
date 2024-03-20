package com.ems.entities;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long id;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Other properties and getters/setters
}

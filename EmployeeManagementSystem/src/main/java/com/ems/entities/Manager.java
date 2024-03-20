package com.ems.entities;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Other properties and getters/setters
}

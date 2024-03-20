package com.ems.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

    // Other properties and getters/setters
}

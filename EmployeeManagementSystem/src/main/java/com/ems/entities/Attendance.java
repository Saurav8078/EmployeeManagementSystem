package com.ems.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Other properties and getters/setters
}

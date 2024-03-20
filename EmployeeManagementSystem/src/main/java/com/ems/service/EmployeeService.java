package com.ems.service;

import com.ems.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {
    private final SessionFactory sessionFactory;

    public EmployeeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

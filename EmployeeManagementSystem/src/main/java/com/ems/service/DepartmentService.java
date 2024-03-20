package com.ems.service;

import com.ems.entities.Department;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentService {
    private final SessionFactory sessionFactory;

    public DepartmentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void addDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Department getDepartmentById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Department.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

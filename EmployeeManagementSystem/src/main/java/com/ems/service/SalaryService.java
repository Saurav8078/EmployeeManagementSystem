package com.ems.service;

import com.ems.entities.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SalaryService {
    private final SessionFactory sessionFactory;

    public SalaryService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addSalary(Salary salary) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(salary);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Salary getSalaryById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Salary.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateSalary(Salary salary) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(salary);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteSalary(Salary salary) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(salary);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

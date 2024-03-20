package com.ems.service;

import com.ems.entities.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManagerService {
    private final SessionFactory sessionFactory;

    public ManagerService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addManager(Manager manager) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(manager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Manager getManagerById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Manager.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateManager(Manager manager) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(manager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteManager(Manager manager) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(manager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

package com.ems.service;

import com.ems.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProjectService {
    private final SessionFactory sessionFactory;

    public ProjectService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProject(Project project) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Project getProjectById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateProject(Project project) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteProject(Project project) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

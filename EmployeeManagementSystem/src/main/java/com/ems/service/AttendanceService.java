package com.ems.service;

import com.ems.entities.Attendance;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AttendanceService {
    private final SessionFactory sessionFactory;

    public AttendanceService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void addAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Attendance getAttendanceById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Attendance.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void deleteAttendance(Attendance attendance) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(attendance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Inititial session factory creation has failed. " + e);
            throw new ExceptionInInitializerError("Database connection error. ");
        }
    }

    public static Session openSession() throws Exception {
        Session session;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            throw new Exception("Database connection error. ");
        }
        return session;
    }
}

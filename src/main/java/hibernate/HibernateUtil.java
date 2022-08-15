package hibernate;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(CompaniesDao.class)
                .addAnnotatedClass(CustomersDao.class)
                .addAnnotatedClass(DevelopersDao.class)
                .addAnnotatedClass(ProjectsDao.class)
                .addAnnotatedClass(SkillsDao.class)
                .buildSessionFactory();
    }



}

package hibernate.dll;

import entity.CompaniesDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompaniesRepository implements Repository<CompaniesDao>{

    private HibernateUtil util = new HibernateUtil();

    @Override
    public List getAll() {
        Session session = util.getSessionFactory().openSession();
        List<CompaniesDao> list = session.createQuery("from CompaniesDao", CompaniesDao.class).list();
        session.close();
        return list;
    }

    @Override
    public void save(CompaniesDao companiesDao) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(companiesDao);
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Long id) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(getById(id));
        transaction.commit();
        session.close();
    }

    @Override
    public void update(CompaniesDao companiesDao) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(companiesDao);
        transaction.commit();
        session.close();
    }

    public CompaniesDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        CompaniesDao companiesDao = session.get(CompaniesDao.class, id);
        session.close();
        return companiesDao;
    }


}

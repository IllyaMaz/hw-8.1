package hibernate.dll;

import entity.CompaniesDao;
import entity.CustomersDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomersRepository implements Repository<CustomersDao>{
    private HibernateUtil util = new HibernateUtil();

    @Override
    public List getAll() {
        Session session = util.getSessionFactory().openSession();
        List<CustomersDao> list = session.createQuery("from CustomersDao", CustomersDao.class).list();
        session.close();
        return list;
    }

    @Override
    public void save(CustomersDao customersDao) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customersDao);
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
    public void update(CustomersDao customersDao) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customersDao);
        transaction.commit();
        session.close();
    }

    public CustomersDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        CustomersDao customersDao = session.get(CustomersDao.class, id);
        session.close();
        return customersDao;
    }

    public CompaniesDao getCompaniesByName(String name){
        Session session = util.getSessionFactory().openSession();
        Query<CompaniesDao> query = session.createQuery("from CompaniesDao where name = :name", CompaniesDao.class);
        query.setParameter("name",name);
        CompaniesDao singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }
}

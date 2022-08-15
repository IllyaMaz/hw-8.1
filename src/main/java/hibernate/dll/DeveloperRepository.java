package hibernate.dll;

import entity.DevelopersDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepository implements Repository<DevelopersDao>{
    private HibernateUtil util = new HibernateUtil();

    @Override
    public List getAll() {
        Session session = util.getSessionFactory().openSession();
        List<DevelopersDao> list = session.createQuery("from DevelopersDao", DevelopersDao.class).list();
        session.close();
        return list;
    }

    @Override
    public void save(DevelopersDao developersDao) {

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
    public void update(DevelopersDao developersDao) {

    }

    private DevelopersDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        DevelopersDao developersDao = session.get(DevelopersDao.class, id);
        session.close();
        return developersDao;
    }
}

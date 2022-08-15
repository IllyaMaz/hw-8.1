package hibernate.dll;

import entity.SkillsDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillsRepository implements Repository<SkillsDao>{
    private HibernateUtil util = new HibernateUtil();

    @Override
    public List getAll() {
        Session session = util.getSessionFactory().openSession();
        List<SkillsDao> list = session.createQuery("from SkillsDao", SkillsDao.class).list();
        session.close();
        return list;
    }

    @Override
    public void save(SkillsDao skillsDao) {

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
    public void update(SkillsDao skillsDao) {

    }

    private SkillsDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        SkillsDao skillsDao = session.get(SkillsDao.class, id);
        session.close();
        return skillsDao;
    }
}

package hibernate.dll;

import entity.ProjectsDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProjectsRepository implements Repository<ProjectsDao>{
    private HibernateUtil util = new HibernateUtil();

    @Override
    public List getAll() {
        Session session = util.getSessionFactory().openSession();
        List<ProjectsDao> list = session.createQuery("from ProjectsDao", ProjectsDao.class).list();
        session.close();
        return list;
    }

    @Override
    public void save(ProjectsDao projectsDao) {

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
    public void update(ProjectsDao projectsDao) {

    }

    private ProjectsDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        ProjectsDao projectsDao = session.get(ProjectsDao.class, id);
        session.close();
        return projectsDao;
    }
}

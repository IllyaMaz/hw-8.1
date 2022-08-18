package hibernate.dll;

import entity.CompaniesDao;
import entity.CustomersDao;
import entity.ProjectsDao;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(projectsDao);
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
    public void update(ProjectsDao projectsDao) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(projectsDao);
        transaction.commit();
        session.close();
    }

    public ProjectsDao getById(Long id){
        Session session = util.getSessionFactory().openSession();
        ProjectsDao projectsDao = session.get(ProjectsDao.class, id);
        session.close();
        return projectsDao;
    }

    public CompaniesDao getCompaniesByName(String name){
        Session session = util.getSessionFactory().openSession();
        Query<CompaniesDao> query = session.createQuery("from CompaniesDao where name = :name", CompaniesDao.class);
        query.setParameter("name",name);
        CompaniesDao singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }

    public CustomersDao getCustomerByName(String name){
        Session session = util.getSessionFactory().openSession();
        Query<CustomersDao> query = session.createQuery("from CustomersDao where name = :name", CustomersDao.class);
        query.setParameter("name",name);
        CustomersDao singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }
}

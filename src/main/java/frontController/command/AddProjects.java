package frontController.command;

import entity.CompaniesDao;
import entity.CustomersDao;
import entity.ProjectsDao;
import hibernate.dll.ProjectsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProjects implements Command {
    private ProjectsRepository repository = new ProjectsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String deadline = req.getParameter("deadline");
        String nameCompany = req.getParameter("nameCompany");
        String nameCustomer = req.getParameter("nameCustomer");

        CompaniesDao companiesByName = repository.getCompaniesByName(nameCompany);
        CustomersDao customerByName = repository.getCustomerByName(nameCustomer);

        ProjectsDao projectsDao = new ProjectsDao();
        projectsDao.setId(id);
        projectsDao.setName(name);
        projectsDao.setDeadline(deadline);
        projectsDao.setCompaniesDao(companiesByName);
        projectsDao.setCustomersDao(customerByName);

        repository.save(projectsDao);

        try {
            resp.sendRedirect("/projects/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

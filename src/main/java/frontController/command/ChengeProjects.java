package frontController.command;

import entity.CompaniesDao;
import entity.CustomersDao;
import entity.ProjectsDao;
import hibernate.dll.ProjectsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengeProjects implements Command{
    private ProjectsRepository repository = new ProjectsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String deadline = req.getParameter("deadline");
        String nameCompany = req.getParameter("nameCompany");
        String nameCustomer = req.getParameter("nameCustomer");

        ProjectsDao byId = repository.getById(id);

        if (!name.equals("")){
            byId.setName(name);
        }

        if (!deadline.equals("")){
            byId.setDeadline(deadline);
        }

        if (!nameCompany.equals("")){
            CompaniesDao companiesByName = repository.getCompaniesByName(nameCompany);
            byId.setCompaniesDao(companiesByName);
        }

        if (!nameCustomer.equals("")){
            CustomersDao customerByName = repository.getCustomerByName(nameCustomer);
            byId.setCustomersDao(customerByName);
        }

        repository.update(byId);

        try {
            resp.sendRedirect("/projects/chenge");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

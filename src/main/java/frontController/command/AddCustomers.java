package frontController.command;

import entity.CompaniesDao;
import entity.CustomersDao;
import hibernate.dll.CustomersRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCustomers implements Command{
    private CustomersRepository repository = new CustomersRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String nameCompany = req.getParameter("nameCompany");

        CompaniesDao companiesByName = repository.getCompaniesByName(nameCompany);

        CustomersDao customersDao = new CustomersDao();
        customersDao.setId(id);
        customersDao.setName(name);
        customersDao.setCompaniesDao(companiesByName);

        repository.save(customersDao);

        try {
            resp.sendRedirect("/customers/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

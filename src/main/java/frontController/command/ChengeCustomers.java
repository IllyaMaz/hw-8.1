package frontController.command;

import entity.CompaniesDao;
import entity.CustomersDao;
import hibernate.dll.CustomersRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengeCustomers implements Command{
    private CustomersRepository repository = new CustomersRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String newCompany = req.getParameter("newCompany");
        CustomersDao chenge = repository.getById(id);

        if (!name.equals("")){
            chenge.setName(name);
        }

        if (!newCompany.equals("")){
            CompaniesDao companiesByName = repository.getCompaniesByName(newCompany);
            chenge.setCompaniesDao(companiesByName);
        }

        repository.update(chenge);

        try {
            resp.sendRedirect("/customers/chenge");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package frontController.command;

import entity.CompaniesDao;
import hibernate.dll.CompaniesRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCompanies implements Command{
    private CompaniesRepository repository = new CompaniesRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        CompaniesDao companiesDao = new CompaniesDao();
        companiesDao.setId(id);
        companiesDao.setName(name);

        repository.save(companiesDao);

        try {
            resp.sendRedirect("/companies/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

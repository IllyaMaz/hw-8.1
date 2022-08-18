package frontController.command;

import entity.CompaniesDao;
import hibernate.dll.CompaniesRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengeCompanies implements Command{
    private CompaniesRepository repository = new CompaniesRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");

        CompaniesDao byId = repository.getById(id);
        CompaniesDao modified = byId;
        if (!name.equals("")){
            modified.setName(name);
        }

        repository.update(modified);

        try {
            resp.sendRedirect("/companies/chenge");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

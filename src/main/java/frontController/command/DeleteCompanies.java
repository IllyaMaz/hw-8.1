package frontController.command;

import hibernate.dll.CompaniesRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCompanies implements Command{
    private CompaniesRepository repository = new CompaniesRepository();
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");
        Long id = Long.valueOf(req.getParameter("id"));
        repository.remove(id);
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

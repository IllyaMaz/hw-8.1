package frontController.command;

import hibernate.dll.DeveloperRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDevelopers implements Command{
    private DeveloperRepository repository = new DeveloperRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.parseLong(req.getParameter("id"));
        repository.remove(id);

        try {
            resp.sendRedirect("/developers");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

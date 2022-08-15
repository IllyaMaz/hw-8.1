package frontController.command;

import hibernate.dll.ProjectsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProjects implements Command{
    private ProjectsRepository repository = new ProjectsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");
        Long id = Long.valueOf(req.getParameter("id"));
        repository.remove(id);

        try {
            resp.sendRedirect("/projects");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

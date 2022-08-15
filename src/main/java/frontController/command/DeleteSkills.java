package frontController.command;

import hibernate.dll.SkillsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSkills implements Command{
    private SkillsRepository repository = new SkillsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        repository.remove(id);

        try {
            resp.sendRedirect("/skills");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

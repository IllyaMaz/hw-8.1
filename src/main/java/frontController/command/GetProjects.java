package frontController.command;

import hibernate.dll.ProjectsRepository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetProjects implements Command{
    private ProjectsRepository repository = new ProjectsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        List all = repository.getAll();
        Context context = new Context(
                req.getLocale(),
                Map.of("projects",all)
        );
        try {
            engine.process("projects",context,resp.getWriter());
            resp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

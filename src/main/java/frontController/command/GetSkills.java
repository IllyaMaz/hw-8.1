package frontController.command;

import hibernate.dll.SkillsRepository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetSkills implements Command{
    private SkillsRepository repository = new SkillsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");
        List all = repository.getAll();
        Context context = new Context(
                req.getLocale(),
                Map.of("skills",all)
        );
        try {
            engine.process("skills",context,resp.getWriter());
            resp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

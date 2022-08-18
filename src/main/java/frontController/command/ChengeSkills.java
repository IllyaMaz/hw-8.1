package frontController.command;

import entity.DevelopersDao;
import entity.SkillsDao;
import hibernate.dll.SkillsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengeSkills implements Command{
    private SkillsRepository repository = new SkillsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String level = req.getParameter("level");
        String nameDeveloper = req.getParameter("nameDeveloper");

        SkillsDao byId = repository.getById(id);

        if (!name.equals("")){
            byId.setName(name);
        }

        if (!level.equals("")){
            byId.setLevel(level);
        }

        if (!nameDeveloper.equals("")){
            DevelopersDao developerById = repository.getDeveloperById(nameDeveloper);
            byId.setDevelopersDao(developerById);
        }

        repository.update(byId);

        try {
            resp.sendRedirect("/skills/chenge");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

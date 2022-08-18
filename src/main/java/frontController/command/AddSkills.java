package frontController.command;

import entity.DevelopersDao;
import entity.SkillsDao;
import hibernate.dll.SkillsRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSkills implements Command{
    private SkillsRepository repository = new SkillsRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String level = req.getParameter("level");
        String nameDeveloper = req.getParameter("nameDeveloper");

        DevelopersDao developerById = repository.getDeveloperById(nameDeveloper);

        SkillsDao skillsDao = new SkillsDao();
        skillsDao.setId(id);
        skillsDao.setName(name);
        skillsDao.setLevel(level);
        skillsDao.setDevelopersDao(developerById);

        repository.save(skillsDao);

        try {
            resp.sendRedirect("/skills/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package frontController.command;

import entity.DevelopersDao;
import entity.ProjectsDao;
import hibernate.dll.DeveloperRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDevelopers implements Command{
    private DeveloperRepository repository = new DeveloperRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        String nameProject = req.getParameter("nameProject");

        ProjectsDao progectByName = repository.getProgectByName(nameProject);

        DevelopersDao developersDao = new DevelopersDao();
        developersDao.setId(id);
        developersDao.setName(name);
        developersDao.setAge(age);
        developersDao.setGender(gender);
        developersDao.setSalary(salary);
        developersDao.setProjectsDao(progectByName);

        repository.save(developersDao);

        try {
            resp.sendRedirect("/developers/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

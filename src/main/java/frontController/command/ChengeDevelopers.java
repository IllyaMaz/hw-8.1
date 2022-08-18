package frontController.command;

import entity.DevelopersDao;
import entity.ProjectsDao;
import hibernate.dll.DeveloperRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChengeDevelopers implements Command{
    private DeveloperRepository repository = new DeveloperRepository();

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        Long id = Long.valueOf(req.getParameter("id"));
        String newName = req.getParameter("name");
        Integer newAge = Integer.parseInt(req.getParameter("age"));
        String newGender = req.getParameter("gender");
        Integer newSalary = Integer.valueOf(req.getParameter("salary"));
        String newProject = req.getParameter("nameProject");

        DevelopersDao byId = repository.getById(id);

        if (!newName.equals("")){
            byId.setName(newName);
        }

        if (!newAge.equals(null)){
            byId.setAge(newAge);
        }

        if (!newGender.equals("")){
            byId.setGender(newGender);
        }

        if (!newSalary.equals(null)){
            byId.setSalary(newSalary);
        }

        if (!newProject.equals("")){
            ProjectsDao progectByName = repository.getProgectByName(newProject);
            byId.setProjectsDao(progectByName);
        }

        repository.update(byId);

        try {
            resp.sendRedirect("/developers/chenge");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package frontController;

import frontController.command.*;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    private Map<String, Command> map ;

    public FrontController(){
        map = new HashMap<>();

        map.put("GET /", new GetCompanies());
        map.put("GET /customers", new GetCustomers());
        map.put("GET /projects", new GetProjects());
        map.put("GET /developers", new GetDevelopers());
        map.put("GET /skills", new GetSkills());
        map.put("GET /companies/add",new GetCompaniesAddPage());
        map.put("GET /customers/add",new GetCustomersAddPage());
        map.put("GET /developers/add", new GetDevelopersAddPage());
        map.put("GET /projects/add",new GetProjectsAddPage());
        map.put("GET /skills/add", new GetSkillsAddPage());
        map.put("GET /companies/chenge", new GetCompaniesChengePage());
        map.put("GET /customers/chenge", new GetCustomersChengePage());
        map.put("GET /developers/chenge", new GetDevelopersChengePage());
        map.put("GET /projects/chenge", new GetProjectsChengePage());
        map.put("GET /skills/chenge", new GetSkillsChengePage());
        map.put("POST /companies/chenge", new ChengeCompanies());
        map.put("POST /customers/chenge", new ChengeCustomers());
        map.put("POST /developers/chenge", new ChengeDevelopers());
        map.put("POST /projects/chenge", new ChengeProjects());
        map.put("POST /skills/chenge", new ChengeSkills());
        map.put("POST /skills/add", new AddSkills());
        map.put("POST /projects/add",new AddProjects());
        map.put("POST /developers/add",new AddDevelopers());
        map.put("POST /companies/add",new AddCompanies());
        map.put("POST /customers/add", new AddCustomers());
        map.put("POST /companies/delete", new DeleteCompanies());
        map.put("POST /customers/delete", new DeleteCustomer());
        map.put("POST /projects/delete", new DeleteProjects());
        map.put("POST /developers/delete",new DeleteDevelopers());
        map.put("POST /skills/delete",new DeleteSkills());
    }

    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine){
        String s = req.getMethod() + " " + req.getRequestURI();
        map.get(s).procces(req,resp,engine);
    }

}

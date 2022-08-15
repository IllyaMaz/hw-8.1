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

package frontController.command;

import hibernate.dll.CompaniesRepository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetCompanies implements Command {
    private CompaniesRepository repository;

    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine){
        resp.setContentType("text/html");
        repository = new CompaniesRepository();
        List all = repository.getAll();
        Context context = new Context(
                req.getLocale(),
                Map.of("companies",all)
        );
        try {
            engine.process("index",context,resp.getWriter());
            resp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

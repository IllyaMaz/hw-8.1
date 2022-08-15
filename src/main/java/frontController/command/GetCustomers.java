package frontController.command;

import entity.CustomersDao;
import hibernate.dll.CustomersRepository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetCustomers  implements Command{
    private CustomersRepository repository;
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");
        repository = new CustomersRepository();
        List all = repository.getAll();
        Context context = new Context(
                req.getLocale(),
                Map.of("customers",all)
        );
        try {
            engine.process("customers",context,resp.getWriter());
            resp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

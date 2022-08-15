package frontController.command;

import hibernate.dll.CustomersRepository;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomer implements Command{
    private CustomersRepository repository = new CustomersRepository();
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");
        Long id = Long.valueOf(req.getParameter("id"));
        repository.remove(id);
        try {
            resp.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

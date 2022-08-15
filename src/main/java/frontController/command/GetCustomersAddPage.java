package frontController.command;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCustomersAddPage implements Command{
    @Override
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine) {
        resp.setContentType("text/html");

        try {
            engine.process("addCustomers",new Context(), resp.getWriter());
            resp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

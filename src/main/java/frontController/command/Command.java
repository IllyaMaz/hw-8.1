package frontController.command;

import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    public void procces(HttpServletRequest req, HttpServletResponse resp, TemplateEngine engine);
}

package thymlyfControler;

import frontController.FrontController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class ThymlyfControler extends HttpServlet {
    private TemplateEngine engine;
    private FrontController controller;

    @Override
    public void init() throws ServletException {
        this.engine = new TemplateEngine();
        this.controller = new FrontController();
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix(getServletContext().getRealPath("/tamplate/"));
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);

        engine.addTemplateResolver(resolver);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller.procces(req,resp,engine);
    }
}

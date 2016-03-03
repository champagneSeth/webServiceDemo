import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.MultipartConfigElement;

public class APIServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(HelloServlet.class, "/");

        ServletHolder apiServlet = new ServletHolder(new APIServlet());
        apiServlet.getRegistration().setMultipartConfig(new MultipartConfigElement("data/tmp"));
        context.addServlet(apiServlet, "/api");

        server.start();
        server.join();
    }
}

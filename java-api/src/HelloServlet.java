import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        // Set response content type
        rep.setContentType("text/html");

        // Actual logic goes here.
        String html = "<h1>" + message + "</h1>"
                + "<form action=\"api\" method=\"post\" enctype=\"multipart/form-data\">"
                + "<input type=\"text\" name=\"description\" />"
                + "<input type=\"file\" name=\"file\" />"
                + "<input type=\"submit\" />"
                + "</form>";

        PrintWriter out = rep.getWriter();
        out.println(html);
    }

}


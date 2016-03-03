import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class APIServlet extends HttpServlet {

    private Gson gson;

    public void init() throws ServletException {
        gson = new Gson();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Map<String, String> map = new HashMap<>();
        map.put("title", "potato");
        map.put("src", "images/harden.jpg");

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(map));

//        response.setContentType("image/jpeg");
//
//        String fileName = request.getParameter("file");
//        Path file = Paths.get("images/" + fileName);
//        InputStream is = Files.newInputStream(file);
//        OutputStream oos = response.getOutputStream();
//
//        int c;
//        byte[] buf = new byte[8192];
//        while ((c = is.read(buf, 0, buf.length)) > 0) {
//            oos.write(buf, 0, c);
//            oos.flush();
//        }
//
//        is.close();
//        oos.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieves <input type="text" name="description">
        String description = request.getParameter("description");
        System.out.println(description);

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();

        Path file = Paths.get("images/" + fileName);
        Files.write(file, IOUtils.toByteArray(fileContent));

        response.setContentType("application/json");

        Map<String, String> map = new HashMap<>();
        map.put("success", "File uploaded and saved");

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(map));
    }

}
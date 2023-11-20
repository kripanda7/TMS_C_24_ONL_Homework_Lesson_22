package by.teachmeskills.lesson23.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

@WebServlet("/book")
public class BookDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=book.txt");
        Properties appProps = new Properties();
        appProps.load(getClass().getClassLoader().getResourceAsStream("application.yml"));
        try (InputStream in = new FileInputStream(appProps.getProperty("storagePath") + "book.txt");
             OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[1048];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}

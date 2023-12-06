package by.teachmeskills.lesson32;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() != null) {
            switch (req.getPathInfo()) {
                case "/home":
                    getServletContext().getNamedDispatcher("home").forward(req, resp);
                case "/info":
                    getServletContext().getNamedDispatcher("info").forward(req, resp);
                case "/contacts":
                    getServletContext().getNamedDispatcher("contacts").forward(req, resp);
            }
        }
    }
}

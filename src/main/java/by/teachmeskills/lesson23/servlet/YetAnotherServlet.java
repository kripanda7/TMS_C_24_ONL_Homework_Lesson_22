package by.teachmeskills.lesson23.servlet;

import by.teachmeskills.lesson23.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static by.teachmeskills.lesson23.servlet.RequestScopeServlet.REQUEST_ATTRIBUTE_NAME;
import static by.teachmeskills.lesson23.servlet.ServletContext.SERVLET_CONTEXT_ATTRIBUTE_NAME;

@WebServlet(urlPatterns = "/other", name = "other")
public class YetAnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = (UserDto) req.getAttribute(REQUEST_ATTRIBUTE_NAME);
        if (user == null) {
            resp.getWriter().println("you should firstly fetch /request");
        } else {
            resp.getWriter().println("User name %s and login %s".formatted(user.getName(), user.getLogin()));
            resp.getWriter().println("Amount %s".formatted(Objects.toString(getServletContext().getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME), String.valueOf(0))));
        }
    }
}

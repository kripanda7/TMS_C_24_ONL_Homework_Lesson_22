package by.teachmeskills.lesson26.servlet;

import by.teachmeskills.lesson26.service.SignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private final SignUpService signUpService = new SignUpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmedPassword = req.getParameter("confirmedPassword");
        req.setAttribute("login", login);
        req.setAttribute("password", password);
        req.setAttribute("confirmedPassword", confirmedPassword);
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put("loginRequired", login);
        fieldsMap.put("passwordRequired", password);
        fieldsMap.put("confirmedPasswordRequired", confirmedPassword);
        List<String> emptyFields = signUpService.getEmptyFields(fieldsMap);
        if (!emptyFields.isEmpty()) {
            for (String field : emptyFields) {
                req.setAttribute(field, "*");
                req.setAttribute("title", "Please, try again!");
            }
        } else if (!signUpService.isPasswordTheSame(password, confirmedPassword)) {
            req.setAttribute("diffPassword", "Please, enter the same password!");
        } else {
            req.setAttribute("title", String.format("%s, you successful signed up!", login));
        }
        getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp").forward(req, resp);
    }
}
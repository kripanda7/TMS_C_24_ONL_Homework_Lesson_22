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

    public SignUpService signUpService = new SignUpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("login", req.getParameter("login"));
        req.setAttribute("password", req.getParameter("password"));
        req.setAttribute("confirmedPassword", req.getParameter("confirmedPassword"));
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put("loginRequired", req.getParameter("login"));
        fieldsMap.put("passwordRequired", req.getParameter("password"));
        fieldsMap.put("confirmedPasswordRequired", req.getParameter("confirmedPassword"));
        List<String> emptyFields = signUpService.getEmptyFields(fieldsMap);
        if (!emptyFields.isEmpty()) {
            for (String field : emptyFields) {
                req.setAttribute(field, "*");
                req.setAttribute("title", "Please, try again!");
            }
        } else if (!signUpService.isPasswordTheSame(req.getParameter("password"), req.getParameter("confirmedPassword"))) {
            req.setAttribute("diffPassword", "Please, enter the same password!");
        } else {
            req.setAttribute("title", String.format("%s, you successful signed up!", req.getParameter("login")));
        }
        getServletContext().getRequestDispatcher("/WEB-INF/sign-up.jsp").forward(req, resp);
    }
}
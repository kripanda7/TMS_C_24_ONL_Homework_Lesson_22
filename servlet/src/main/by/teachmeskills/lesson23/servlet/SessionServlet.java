package by.teachmeskills.lesson23.servlet;

import by.teachmeskills.lesson23.dto.CartDto;
import by.teachmeskills.lesson23.dto.ProductDto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    public static final String SESSION_ATTRIBUTE_NAME = "sessionAttr";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("test", "test");
        CartDto cartDto = new CartDto();
        cartDto.setProducts(List.of(new ProductDto(new BigDecimal(15), "Bread"), new ProductDto(new BigDecimal(20), "milk")));
        httpSession.setAttribute(SESSION_ATTRIBUTE_NAME, cartDto);
    }
}

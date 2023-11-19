package by.teachmeskills.lesson22.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String result = switch (req.getServletPath()) {
            case "/minsk" -> getTime("Europe/Minsk");
            case "/washington" -> getTime("America/Virgin");
            case "/beijing" -> getTime("Asia/Shanghai");
            default -> getTime("Europe/Paris");
        };
        resp.getWriter().println(result);
    }

    public static String getTime(String timeZone) {
        return LocalDateTime.now()
                .atZone(ZoneId.of(timeZone))
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a"));
    }
}

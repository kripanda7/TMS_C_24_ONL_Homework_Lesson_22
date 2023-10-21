import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String result = switch (req.getServletPath()) {
            case "/minsk" -> getTime("Europe/Minsk");
            case "/washington" -> getTime("America/Virgin");
            case "/beijing" -> getTime("Asia/Shanghai");
            default -> "time";
        };
        resp.getWriter().println(result);
    }

    public static String getTime(String timeZone) {
        final DateTime dateTime = new DateTime();
        final DateTimeFormatter outputFormatter
                = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss a").withZone(DateTimeZone.forID(timeZone));
        return outputFormatter.print(dateTime);
    }
}

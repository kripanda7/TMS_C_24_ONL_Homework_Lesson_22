package by.teachmeskills.lesson23.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;

@WebListener
public class ApplicationListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {

    // --- ServletContextListener
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setSessionTimeout(300);
        System.out.println("Application is running.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext is destroyed.");
    }

    // --- HttpSessionAttributeListener

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeAdded(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    // --- HttpSessionListener

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("startedAt", LocalDateTime.now());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session was discarded during");
    }
}

package listener;


import model.User;
import repository.UserRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        User build = User.builder()
                .email("test@gmail.com")
                .password("password")
                .firstName("Pawel")
                .lastName("Wronski")
                .build();

        UserRepository repo = new UserRepository();
        repo.create(build);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

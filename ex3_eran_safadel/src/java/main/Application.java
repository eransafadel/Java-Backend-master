package main;
import main.beans.SessionUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;


// @EnableJdbcHttpSession
@SpringBootApplication
public class Application {

    /* we declare a bean to be      created by Spring in each user session */
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionUser SessionUser () {
        SessionUser session =  new SessionUser();
        return session;
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}

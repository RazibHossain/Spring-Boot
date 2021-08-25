package ConfigurationBean;

import Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCofiguration {
    @Bean
    public UserService getUser(){
        return new UserService();
    }
}

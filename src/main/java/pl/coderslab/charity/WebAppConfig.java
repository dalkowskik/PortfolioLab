package pl.coderslab.charity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("login");
        registry.addViewController("/error").setViewName("404");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("home");





    }
}















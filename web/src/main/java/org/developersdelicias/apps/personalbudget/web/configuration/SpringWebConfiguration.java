package org.developersdelicias.apps.personalbudget.web.configuration;

import com.lyncode.jtwig.mvc.JtwigViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan({"org.developersdelicias.apps.personalbudget"})
@EnableTransactionManagement
@Import({SpringSecurityConfiguration.class})
public class SpringWebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public ViewResolver viewResolver() {
        JtwigViewResolver viewResolver = new JtwigViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/twig/");
        viewResolver.setSuffix(".twig");
        return viewResolver;
    }
}

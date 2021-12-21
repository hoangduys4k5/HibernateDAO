package baitapnha.hoangduy.customerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import baitapnha.hoangduy.customerdemo.repository.CustomerRepository;
import baitapnha.hoangduy.customerdemo.repository.CustomerRepositoryImpl;
import baitapnha.hoangduy.customerdemo.services.CustomerService;
import baitapnha.hoangduy.customerdemo.services.CustomerServiceImpl;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "baitapnha.hoangduy.customerdemo"
})

public class ApplicationConfig {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }
    
}
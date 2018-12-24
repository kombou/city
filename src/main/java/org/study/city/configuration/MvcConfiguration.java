package org.study.city.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("org.everest.cosmos.controller")
public class MvcConfiguration implements WebMvcConfigurer {

    private ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver templateResolver(){

        SpringResourceTemplateResolver templateResolver = new
                SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCacheable(false);
        templateResolver.setApplicationContext(applicationContext);

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine templateEngine = new
                SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new LayoutDialect(new GroupingStrategy()));

        return templateEngine;

    }

    @Bean
    public ViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver viewResolver = new
                ThymeleafViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setCache(false);
        viewResolver.setTemplateEngine(springTemplateEngine());
        viewResolver.setOrder(1);

        return viewResolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/dist/**").addResourceLocations("/dist/")
                .setCachePeriod(0);
    }

}

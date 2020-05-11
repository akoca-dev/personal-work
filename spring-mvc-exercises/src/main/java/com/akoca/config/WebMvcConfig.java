package com.akoca.config;

import com.akoca.mvc.interceptor.ExecutionTimerInterceptor;
import com.akoca.mvc.interceptor.HeaderInterceptor;
import com.akoca.mvc.interceptor.VisitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan("com.akoca")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private HeaderInterceptor headerInterceptor;

    @Autowired
    private ExecutionTimerInterceptor executionTimerInterceptor;

    @Autowired
    private VisitorInterceptor visitorInterceptor;

    @Bean
    public DataSource getDataSource() {
        final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        dataSourceLookup.setResourceRef(true);
        DataSource dataSource = dataSourceLookup.getDataSource("jdbc/springMasterclassDatabase");

        return dataSource;
    }

    @Bean
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(true);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);

        return requestMappingHandlerMapping;
    }

    @Bean
    UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/view/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);

        return urlBasedViewResolver;
    }

    @Bean(name="serviceLengthOptions")
    public PropertiesFactoryBean mapper() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("property/organization-service-year.properties"));

        return bean;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("home");
        registry.addViewController("/").setViewName("testMvcHome");
        //registry.addViewController("/").setViewName("sessionAttrHome");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executionTimerInterceptor);
        registry.addInterceptor(headerInterceptor).addPathPatterns("/location");
        registry.addInterceptor(visitorInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/css/test/");
    }
}
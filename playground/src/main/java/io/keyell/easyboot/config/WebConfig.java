package io.keyell.easyboot.config;

import io.keyell.easyboot.filter.OneFilter;
import io.keyell.easyboot.filter.TwoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.FilterRegistration;

/**
 * @author huangke 创建于 2019/2/26
 */

@EnableWebMvc
@ComponentScan
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 不写controller 指定一些页面的跳转逻辑
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/loginpage").setViewName("login");
        registry.addViewController("/loginx").setViewName("loginx");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    // Only used when running in embedded servlet
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    public OneFilter doOne() {
        return new OneFilter();
    }

    @Bean
    public TwoFilter doTwo() {
        return new TwoFilter();
    }

    @Bean
    public FilterRegistrationBean<OneFilter> registerOneFilter(OneFilter oneFilter) {
        FilterRegistrationBean<OneFilter> registrationBean = new FilterRegistrationBean<>(oneFilter);

        // TODO javax.servlet.FilterRegistration
        registrationBean.addInitParameter("p1", "HK");
        registrationBean.addInitParameter("p2", "FF");

        registrationBean.addUrlPatterns("/*");

        return registrationBean;


    }

    @Bean
    public FilterRegistrationBean<TwoFilter> registerOneFilter() {
        FilterRegistrationBean<TwoFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(doTwo());

        // TODO javax.servlet.FilterRegistration
        registrationBean.addInitParameter("p1", "HK2");
        registrationBean.addInitParameter("p2", "FF2");

        registrationBean.addUrlPatterns("/*");

        return registrationBean;


    }



}
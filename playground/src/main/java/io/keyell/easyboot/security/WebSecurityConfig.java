package io.keyell.easyboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 使用了 @EnableWebSecurity 注解，不再需要使用@Configuratio，同时引入了
 * WebSecurityConfiguration 和 SpringWebMvcImportSelector
 *
 * @author huangke 创建于 2019/2/18
 */
//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // https://blog.csdn.net/wangb_java/article/details/86490235 表单登录注销的例子
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/login", "/loginx").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginx")
                // 默认loginProcessingUrl 和loginPage一致
                /**
                 * @see org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer#updateAuthenticationDefaults
                 */
                // loginProcessingUrl 应该保持和 form表单中的action一致 不需要人工写登录处理的controller
//                .loginProcessingUrl("/loginxxx")
                .permitAll()
                .and().httpBasic()
                .and().
                logout().
                logoutUrl("/logout").
                permitAll().and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // TODO spring 5.0 需要设置 passwordEncoder
        // There is no PasswordEncoder mapped for the id "null"
        // https://blog.csdn.net/m0_37564404/article/details/83378630
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("p")).roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("u").password(passwordEncoder().encode("u")).roles("USER");

    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
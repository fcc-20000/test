package cn.bdqn.warehousemanager.config;

import cn.bdqn.warehousemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/*配置Sercuity*/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(cfisms());
                        object.setAccessDecisionManager(cadm());
                        return object;
                    }
                })
                .antMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(3600).and()
                .csrf()
                .disable();
//                .antMatchers(HttpMethod.GET, "/user-login","/loginpage.html").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //指定登录页的路径
//                .loginPage("/user-login")
//                //指定自定义form表单请求的路径
//                .loginProcessingUrl("/authentication/form")
//                .permitAll();
//        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
//        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.logout().logoutSuccessUrl("/index");
    }

    @Bean
    CustomFileterInvocationSecurityMetadataSource cfisms() {
        return new CustomFileterInvocationSecurityMetadataSource();
    }

    @Bean
    CustomAccessDecisionManager cadm() {
        return new CustomAccessDecisionManager();
    }

    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}

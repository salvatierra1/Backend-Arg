package com.salvatierravictor.portfolio.auth.config;

import com.salvatierravictor.portfolio.auth.filter.JwtRequestFilter;
import com.salvatierravictor.portfolio.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsCustomService userDetailsCustomService;

    public SecurityConfiguration(@Autowired @Lazy UserDetailsCustomService userDetailsCustomService) {
        this.userDetailsCustomService = userDetailsCustomService;
    }
    @Autowired
    @Lazy
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsCustomService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors();
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/signup", "/auth/signin").permitAll()
                .antMatchers(HttpMethod.GET, "/profile/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/profile").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/profile/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/profile/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/about").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/about/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/about/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/education").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/education/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/education/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/skills").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/skills/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/skills/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/project").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/project/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/project/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
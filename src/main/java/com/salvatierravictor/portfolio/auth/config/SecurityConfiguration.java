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
                .antMatchers(HttpMethod.GET, "/perfil/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/perfil").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/perfil/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/perfil/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/acerca").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/acerca/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/acerca/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/educacion").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/educacion/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/educacion/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/habilidades").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/habilidades/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/habilidades/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/proyectos").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/proyectos/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/proyectos/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
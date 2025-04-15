package com.example.sitoweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeHttpRequests(authorize -> authorize
.requestMatchers("/login","/cliente/**","/loginCliente**","/logoutCliente**",  "/ordine/**", "/registrazionecliente/**",  "/css/**","/foto/**","/fotodonna/**").permitAll()
.anyRequest().authenticated())
.formLogin(form -> form
.loginPage("/login")
.permitAll())
.logout(logout -> logout
.deleteCookies("JSESSIONID")
.invalidateHttpSession(true)
.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
.logoutSuccessUrl("/login?logout")
.permitAll());
return http.build();
}

}

package me.dio.web.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@SecurityScheme(name="api", scheme="basic", type=SecuritySchemeType.HTTP, in=SecuritySchemeIn.HEADER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override // User Login
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("java")
		.password(passwordEncoder().encode("123"))
		.authorities("ADMIN");
	}
	/*
	@Override // Not authorized
	   public void configure(WebSecurity web) {
	    web.ignoring()
	    .antMatchers("/v3/api-docs/**", "/swagger-ui/**");
	   } */
		
	@Override // Authorized Authentication
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/swagger-ui/**","/v3/api-docs/**","/","csrf").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic();
		http.csrf().disable();
	} 

	@Bean
	PasswordEncoder passwordEncoder() {		
		return new BCryptPasswordEncoder();
	}
}

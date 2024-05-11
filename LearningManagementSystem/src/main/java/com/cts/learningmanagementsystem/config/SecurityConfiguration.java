package com.cts.learningmanagementsystem.config;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import com.cts.learningmanagementsystem.service.LMSServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	LMSServiceImpl lmsServiceImpl;
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
           
        return http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
//                  .antMatchers("/**").permitAll()
                  .antMatchers("/admin/*")
        		  .hasRole("ADMIN")
        		  .antMatchers("/user/**")
        		  .hasAnyRole("ADMIN","USER")
        		  .antMatchers("/")
        		  .permitAll()
          		  .antMatchers("/api/v1.0/lms/company/register")
          		  .permitAll()
          		  .antMatchers("/admin/api/v1.0/lms/courses/getall")
        		  .permitAll()
          		  .antMatchers("/login")
          		  .permitAll()
          		  .anyRequest().authenticated()
                        )
                  .formLogin()
           //       .loginPage("/login")
                  .defaultSuccessUrl("/welcome").and()
                  .csrf().disable()
                  .build();
              
    }
	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//	    return web -> web.ignoring().antMatchers("/api/v1.0/lms/company/register","/admin/api/v1.0/lms/courses/getall");
//	}

	

	 

	
}

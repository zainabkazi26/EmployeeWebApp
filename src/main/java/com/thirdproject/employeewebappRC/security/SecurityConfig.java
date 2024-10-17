package com.thirdproject.employeewebappRC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thirdproject.employeewebappRC.serviceImpl.MyUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(empAuthProvider());
	}

	@Bean
	public DaoAuthenticationProvider empAuthProvider() {
		DaoAuthenticationProvider empDao = new DaoAuthenticationProvider();
		empDao.setUserDetailsService(empUser());
		empDao.setPasswordEncoder(empPassword());
		return empDao;
	}

	@Bean
	public PasswordEncoder empPassword() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService empUser() {
		
		return new MyUserDetailsService();
	}

	
	@Override
	public void configure(HttpSecurity http) {
		try {

			http.httpBasic().and().authorizeRequests().antMatchers("/api/employees/createEmployee")
					.hasAuthority("ADMIN").antMatchers("/**").permitAll().anyRequest().authenticated().and().headers()
					.frameOptions().disable().and().cors().and().csrf().disable();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

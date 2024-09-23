package com.first.springproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.first.springproject.services.impl.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private SecurityCustomUserDetailsService securityCustomUserDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(authorize -> {
			// authorize.requestMatchers("/dashboard").permitAll();
//			authorize.requestMatchers(HttpMethod.POST,"/login2", "/authenticate", "/do-logout").permitAll();
			authorize.requestMatchers("/user/**").authenticated();
			authorize.anyRequest().permitAll();
		});
		 //httpSecurity.formLogin(Customizer.withDefaults());
		httpSecurity.formLogin(formlogin-> {
			formlogin.loginPage("/login2");
			formlogin.loginProcessingUrl("/authenticate");
			formlogin.successForwardUrl("/user/userdashboard");
			formlogin.usernameParameter("email");
			formlogin.passwordParameter("password");
		});
		httpSecurity.csrf(AbstractHttpConfigurer::disable);
		httpSecurity.logout(logoutForm -> {
			logoutForm.logoutUrl("/do-logout");
			logoutForm.logoutSuccessUrl("/login2?logout=true");
		});
		return httpSecurity.build();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

package com.learning.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class Customconfig {
	
	private final UserDetailsService userDetailsService;
	
	


	public Customconfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}


	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity security)
	{
		return security.authorizeHttpRequests(customizer -> customizer.requestMatchers("/register","/login").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.build();
	}
	
	
//    @Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails rohith = User.withUsername("rohith").password("{noop}rohith").roles("USER").build();
//		UserDetails sharan = User.withUsername("sharan").password("{noop}mani").roles("USER").build();
//		
//		return new InMemoryUserDetailsManager(rohith,sharan);
//	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder(14);
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}

}

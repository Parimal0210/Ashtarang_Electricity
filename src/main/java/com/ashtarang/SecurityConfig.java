//package com.ashtarang;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf(AbstractHttpConfigurer::disable)
//			.cors(AbstractHttpConfigurer::disable)
//			 .authorizeHttpRequests(authorize -> 
//			 							authorize.anyRequest().permitAll());
////				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////				.authorizeHttpRequests(matcher -> matcher.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
////						.anyRequest().authenticated());
//		return http.build();
//	}
//}

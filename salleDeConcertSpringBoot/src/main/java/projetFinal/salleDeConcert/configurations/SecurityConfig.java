package projetFinal.salleDeConcert.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// @formatter:off
//		return http.antMatcher("/api/**")
//				.csrf(csrf -> csrf.disable())
//				.authorizeRequests(requests ->  requests
//														.antMatchers("/api/commande/**").hasRole("CLIENT")
//														.anyRequest().hasAnyRole("ADMIN"))
//				.httpBasic(withDefaults())
//				.build();

		return http.antMatcher("/api/**")
						.csrf().disable()
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and()
						.authorizeRequests()
						.antMatchers(HttpMethod.OPTIONS).permitAll()
							//manque un truc pour angular
//							.antMatchers(HttpMethod.POST,"/api/client/inscription").anonymous()
//							.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
//							.antMatchers("/api/commande").hasRole("CLIENT")
//							.anyRequest().hasAnyRole("ADMIN")
							.anyRequest().authenticated()
						.and()
						.httpBasic()
						.and()
						.build();

		// @formatter:on
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

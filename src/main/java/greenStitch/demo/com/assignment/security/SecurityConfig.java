package greenStitch.demo.com.assignment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .requestMatchers("/signup").permitAll() // Allow signup endpoint without authentication
            .anyRequest().authenticated() // Require authentication for all other endpoints
            .and()
            .csrf().disable(); // Disable CSRF protection for simplicity (not recommended for production)
    }
}

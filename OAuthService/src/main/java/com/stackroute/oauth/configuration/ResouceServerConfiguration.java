package com.stackroute.oauth.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResouceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http
        	.antMatcher("/**")
            .authorizeRequests()
                .antMatchers("/register","/swagger-ui.html")
                	.permitAll()
            .anyRequest()
            	.authenticated()
            .and()
            	.cors()
            .and()
        		.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/revoketoken")
					.invalidateHttpSession(true);
    }
}

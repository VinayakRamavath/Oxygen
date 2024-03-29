package com.stackroute.oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
@PropertySource("classpath:application.properties")
@Order(2)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${endpoints.cors.allowed-origins}")
    private String originAllowedUrl;
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
        	.inMemory()
        		.withClient("my-trusted-client")
                .authorizedGrantTypes("client_credentials", "password")
                .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
                .scopes("read","write","trust", "delete")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(5000)
                .secret("secret");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauth2) throws Exception {
        oauth2.checkTokenAccess("isAuthenticated()");
    }
    
  

}
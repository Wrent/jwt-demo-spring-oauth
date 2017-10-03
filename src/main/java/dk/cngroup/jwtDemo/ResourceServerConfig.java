package dk.cngroup.jwtDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore store;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("USER")
                .anyRequest().denyAll();
    }

    //configures the resource server
    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        //set token services to our JWT token specification
        config.tokenServices(tokenServices());
    }

    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        //set token store to our store
        defaultTokenServices.setTokenStore(store);
        return defaultTokenServices;
    }

}

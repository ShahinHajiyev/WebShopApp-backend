

package com.mine.webshopapp.configuration;


import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
     // protect endpoint /api/orders
        http.authorizeRequests()

                .antMatchers("/api/orders/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();





        //response message for code 401
        Okta.configureResourceServer401ResponseBody(http);


        // cors filters
        http.cors();

        //disable csrf because cookies is not used for session tracking
        http.csrf().disable();


    }

}



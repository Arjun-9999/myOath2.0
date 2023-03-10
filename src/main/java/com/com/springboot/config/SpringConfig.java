package com.com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.com.springboot.filter.JwtFilter;
import com.com.springboot.service.CustomerUSerdetailservice;

@Configuration
@EnableWebSecurity
public class SpringConfig  extends WebSecurityConfigurerAdapter {
	  // @Autowired
	    private JwtFilter jwtFilter;
	@Autowired
	CustomerUSerdetailservice customerUSerdetailservice;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customerUSerdetailservice);
		
		
	}

	  @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }
	    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	System.out.println(" 00000000000000000   ");
	        http.csrf().disable().authorizeRequests().antMatchers("/authenticate")
	                .permitAll().anyRequest().authenticated()        		
			 .and().exceptionHandling().and().sessionManagement()
			  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
			 
	    }
}

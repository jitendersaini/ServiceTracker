package com.accenture.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.accenture.tracker.security.CustomUrlAuthenticationSuccessHandler;
import com.accenture.tracker.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsersService userService;

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/_dashboard/**")
				.access("hasAnyRole('USER','VIEWER')").antMatchers("/_admin")
				.access("hasRole('ADMIN')").antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/signup")
				.permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.successHandler(successHandler())
				// defaultSuccessUrl("/_dashboard")
				.usernameParameter("username").passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?logout").and()
				.sessionManagement().invalidSessionUrl("/")
				.sessionAuthenticationErrorUrl("/login").and()
				.exceptionHandling().accessDeniedPage("/403").and().anonymous()
				.disable().csrf().disable();
	}

	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomUrlAuthenticationSuccessHandler();
	}
}
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

		/*http.authorizeRequests().antMatchers("/**")
				.hasAnyRole(new String[] { "USER", "ADMIN" }).and().formLogin()
				.defaultSuccessUrl("/").failureUrl("/login").and().logout()
				.loginPage("/login").permitAll().and().logout()
				.deleteCookies("remove").invalidateHttpSession(true)
				.logoutUrl("/login?logout").logoutSuccessUrl("/").and()
				.sessionManagement().invalidSessionUrl("/")
				.sessionAuthenticationErrorUrl("/").and().csrf().and()
				.exceptionHandling().accessDeniedPage("/403");	*/
		
		//http.logout().logoutUrl("/login?logout").logoutSuccessUrl("/");
		http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_USER')").antMatchers("/users").permitAll()
		.and()
			.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/dashboard")
				.usernameParameter("username").passwordParameter("password").and()
			.logout().logoutSuccessUrl("/login?logout").and()
			.sessionManagement().invalidSessionUrl("/")
			.sessionAuthenticationErrorUrl("/login")
		.and()
			.csrf().and()
			.exceptionHandling().accessDeniedPage("/403").and().anonymous().disable();
	}

	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		return new Md5PasswordEncoder();
	}

	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(
				passwordEncoder());
	}*/
	 

	
	/*@Override
	public UserDetailsService userDetailsServiceBean() {
		return userDetailsService;
	}*/
	 

	/*@Configuration
	@Order(1)
	public static class ResourceSecurityConfigurationAdapter extends
			WebSecurityConfigurerAdapter {

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/resources/**", "/bar-chart/**",
					"/pie-chart/**", "/jquery-ui/**", "/common-js/**",
					"/common-css/**", "/jquery-table/**", "/jq-grid/**",
					"/images/**", "/login-form/**", "/sel-menu/**");
		}
	}*/
}
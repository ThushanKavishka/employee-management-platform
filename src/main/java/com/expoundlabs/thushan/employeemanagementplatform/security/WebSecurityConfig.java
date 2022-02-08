package com.expoundlabs.thushan.employeemanagementplatform.security;

import com.expoundlabs.thushan.employeemanagementplatform.service.CustomUserDetailsService;
import com.expoundlabs.thushan.employeemanagementplatform.util.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//    }

//    @Autowired
//    DataSource dataSource;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * set your configuration on the auth object
         * IN-MEMORY AUTHENTICATION
          */
//        auth.inMemoryAuthentication()
//                .withUser("ExternalUser")
//                .password("2f9acb02faa121bb2a3621951f57b4c690655337edee2e5ac350be2b3be88ea8")
//                .roles("DEVELOPER")
//                .and()
//                .withUser("ExternalUser2")
//                .password("2f9acb02faa121bb2a3621951f57b4c690655337edee2e5ac350be2b3be88ea9")
//                .roles("MANAGER");

        /**
         * set your configuration on the auth object
         * JDBC AUTHENTICATION DEFAULT SCHEMA
         */
//        auth.jdbcAuthentication()
//            .dataSource(dataSource);
//            .withDefaultSchema()
//            .withUser(
//                    User.withUsername("developer")
//                    .password("dev")
//                    .roles("DEVELOPER")
//
//            )
//            .withUser(
//                    User.withUsername("admin")
//                            .password("admin")
//                            .roles("ADMIN")
//            );

        /**
         * set your configuration on the auth object
         * JDBC AUTHENTICATION MANUALLY CREATED SCHEMA
         */
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);


        /**
         * set your configuration on the auth object
         * JDBC AUTHENTICATION MANUALLY CREATED SCHEMA WITH MANUAL QUERIES
         */
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled " +
//                        "from users " +
//                        "where username = ?")
//                .authoritiesByUsernameQuery("select username, authority " +
//                        "from authorities " +
//                        "where username = ?");

        /**
         * set your configuration on the auth object
         * USER DETAILS SERVICE AUTHENTICATION USING JPA
         */
        auth.userDetailsService(userDetailsService);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * SPRING SECURITY AUTHORIZATION FOR BASIC
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/api/v1/admin").hasRole("ADMIN")
//                .antMatchers("/api/v1/developer").hasRole("DEVELOPER")
////                .antMatchers("/**").hasAnyRole("DEVELOPER", "ADMIN")
//                .antMatchers("/").permitAll();
////    }

    /**
     * SPRING SECURITY AUTHORIZATION FOR JWT
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/api/auth/v1/authenticate").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

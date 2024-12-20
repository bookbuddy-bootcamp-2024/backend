package com.creditacceptance.bookbuddy.com.bookbuddybe.config;


import com.creditacceptance.bookbuddy.com.bookbuddybe.security.JWTAuthenticationentryPoint;
import com.creditacceptance.bookbuddy.com.bookbuddybe.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor

public class SpringSecurityConfig {
    private  UserDetailsService userDetailsService;
    private JWTAuthenticationentryPoint jwtAuthenticationentryPoint;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.csrf((csrf)->csrf.disable()).authorizeHttpRequests((authorize)->{
//            authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.GET, "/api/**").hasRole("USER");
            authorize.requestMatchers("/api/auth/**").permitAll();
            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());

        http.exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationentryPoint));
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder().username("john").password(passwordEncoder().encode("password")).roles("USER").build();
//        UserDetails adminUser = User.builder().username("admin").password(passwordEncoder().encode("password")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1, adminUser);
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

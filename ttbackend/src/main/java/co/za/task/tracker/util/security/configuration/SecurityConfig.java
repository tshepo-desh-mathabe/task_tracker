package co.za.task.tracker.util.security.configuration;

import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.constants.ServicePath;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import co.za.task.tracker.util.security.CustomUserDetailsService;
import co.za.task.tracker.util.security.JwtAuthenticationEntryPoint;
import co.za.task.tracker.util.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetails;
    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Deprecated
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetails)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * After deployment, delete this method. Will be using different DB for testing
     */
    @Bean
    public SecurityFilterChain allowH2Database(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(req -> req.requestMatchers(antPathReqMatcher("/h2-console/**")).permitAll()
                )
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(antPathReqMatcher("/h2-console/**")))
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeHttpRequests(req -> req
                        .requestMatchers(permittedPaths()).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    private AntPathRequestMatcher[] permittedPaths() {
        final AntPathRequestMatcher[] paths = {
                antPathReqMatcher(concatenateString(ServicePath.USER_ENTRY_POINT, ServicePath.USER_LOGIN)),
                antPathReqMatcher(concatenateString(ServicePath.USER_ENTRY_POINT, ServicePath.USER_LOGOUT))
        };
        return paths;
    }

    private String concatenateString(String val1, String val2) {
        return String.format("%s%s", val1, val2);
    }

    private AntPathRequestMatcher antPathReqMatcher(String pattern) {
        return AntPathRequestMatcher.antMatcher(pattern);
    }
}


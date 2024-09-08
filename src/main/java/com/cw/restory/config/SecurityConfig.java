package com.cw.restory.config;

import com.cw.restory.config.Handler.Http401Handler;
import com.cw.restory.config.Handler.Http403Handler;
import com.cw.restory.config.Handler.LoginFailHandler;
import com.cw.restory.config.Handler.LoginSuccessHandler;
import com.cw.restory.config.filter.AuthFilter;
import com.cw.restory.domain.user.entity.User;
import com.cw.restory.domain.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final DataSource dataSource;

    @Value("${server.url}")
    private String serverUrl;
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers("/h2-console/**")
                .requestMatchers( "/favicon.ico")
                .requestMatchers( "/error")
                .requestMatchers( "/api/docs")
                .requestMatchers( "/api/swagger-ui/**")
                .requestMatchers( "/swagger-resources/**")
                .requestMatchers( "/v3/api-docs/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/auth/login").permitAll()
//                        .requestMatchers("/auth/signup").permitAll()

                            .requestMatchers("/sample/add").hasRole("USER")
 //                           .requestMatchers("/user").hasRole("USER")
//                        .requestMatchers("/admin")
//                            .access(new WebExpressionAuthorizationManager("hasRole('ADMIN') && hasAuthority('WRITE')"))
//                        .anyRequest().authenticated()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(e -> {
                    e.accessDeniedHandler(new Http403Handler(objectMapper));
                    e.authenticationEntryPoint(new Http401Handler(objectMapper));
                })
                .rememberMe(rm -> rm
                        .rememberMeServices(rememberMeServices())
                )
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public AuthFilter authFilter(){
        AuthFilter filter = new AuthFilter("/auth/login", objectMapper);
        filter.setAuthenticationManager(authenticationManager());
        //filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/"));
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailHandler(objectMapper));
        filter.setSecurityContextRepository(new HttpSessionSecurityContextRepository());
        filter.setRememberMeServices(rememberMeServices());
        return filter;
    }

//    @Bean
//    public SpringSessionRememberMeServices rememberMeServices(){
//        SpringSessionRememberMeServices rememberMeServices = new SpringSessionRememberMeServices();
//        rememberMeServices.setAlwaysRemember(true);
//        rememberMeServices.setValiditySeconds(365 * 24 * 60 * 60);
//
//        return rememberMeServices;
//    }
    @Bean
    public PersistentTokenBasedRememberMeServices rememberMeServices(){
        PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices(
                "restory-remember-token", userDetailsService(userRepository), persistentTokenRepository());
        rememberMeServices.setAlwaysRemember(true);
        rememberMeServices.setTokenValiditySeconds(365 * 24 * 60 * 60);
        return rememberMeServices;
    }

    @Bean
    public JdbcTokenRepositoryImpl persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();

        if("http://localhost".equals(serverUrl)) {
            tokenRepository.setCreateTableOnStartup(true); //h2 로컬용
        }
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService(userRepository));
        provider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(provider);
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return username -> {
            User user = userRepository.findByLoginId(username).orElseThrow(() -> new UsernameNotFoundException(username + "을 찾을 수 없습니다."));

            return new UserPrincipal(user);
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SCryptPasswordEncoder(16,8,1,32,64);
    }
}

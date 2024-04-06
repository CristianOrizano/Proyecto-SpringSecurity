package com.spring.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(config -> config.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/resources/imagen/**", "/css/**", "/js/**", "/DatosImg/**").permitAll()// recursos
                        // estaticos
                        .requestMatchers("/inicio").permitAll()
                        .requestMatchers("/electro/lis", "/electro/grabar", "/electro/buscar", "/electro/eliminar",
                               "/usuario/**")
                        .hasAnyAuthority("ADMIN")
                        .requestMatchers("/electro/catalogo", "/electro/grabarventa", "/electro/selecDeta")
                        .hasAnyAuthority("USER", "ADMIN")

                        .anyRequest().authenticated())
                // .httpBasic() // Habilita la autenticación básica
                // .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/inicio")
                        .permitAll())

                .logout(logout -> logout
                        .invalidateHttpSession(true) // Invalida la sesión HTTP del usuario al cerrar sesión
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())

                .exceptionHandling(exc -> exc
                        .accessDeniedPage("/errores/403")).

                build();

    }




}

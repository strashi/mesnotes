package xyz.strashi.mesnotes.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import xyz.strashi.mesnotes.service.CustumUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private CustumUserDetailsService custumUserDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       /* return http.authorizeHttpRequests(auth ->{
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.requestMatchers("/index").hasAnyRole("USER","ADMIN");
            auth.anyRequest().authenticated();


        }).formLogin(Customizer.withDefaults()).build();*/

        return http.authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/resources/**").permitAll();
                    auth.requestMatchers("/*.css", "*.jpeg").permitAll();
                    auth.requestMatchers("/login").permitAll();
                    auth.requestMatchers("/admin").hasRole("ADMIN");
                    auth.requestMatchers("/notes").hasAnyRole("USER","ADMIN");


                    auth.anyRequest().authenticated();
       /* }).formLogin(Customizer.withDefaults()).build();*/

                }).formLogin(form ->{
                    form.loginPage("/login");
                    form.loginProcessingUrl("/login");
                    form.permitAll();


                }).logout(out ->{
                    out.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                })
                .build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(custumUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

}

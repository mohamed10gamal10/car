package com.Carrental.car.securitysec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class security {

@Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws  Exception
   {
      /* httpSecurity.csrf(csrf->csrf.disable())
               .authorizeHttpRequests(auth->auth.requestMatchers("/Register/add"
                               , "/api/car/login").permitAll());
                       .requestMatchers("/api/car/admin/addcar")
                       .hasAnyRole("Admin")
                       .anyRequest().authenticated())
               .formLogin(Customizer.withDefaults());
*/
      //now
       httpSecurity
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth -> auth
                       .anyRequest().permitAll()
               );

       return httpSecurity.build();

   }
   /*@Bean
    public PasswordEncoder passwordEncoder()
   {
       return new BCryptPasswordEncoder();
   }

    */

}


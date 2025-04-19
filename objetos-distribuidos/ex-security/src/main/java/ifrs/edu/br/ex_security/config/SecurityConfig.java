package ifrs.edu.br.ex_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public UserDetailsManager userDetailsService() {

        UserDetails visitante = User.withDefaultPasswordEncoder()
            .username("visitante")
            .password("visitante")
            .roles("VISITANTE")
            .build();
        
        UserDetails estudante = User.withDefaultPasswordEncoder()
            .username("estudante")
            .password("estudante")
            .roles("ESTUDANTE", "VISITANTE")
            .build();

        UserDetails professor = User.withDefaultPasswordEncoder()
            .username("professor")
            .password("professor")
            .roles("PROFESSOR", "VISITANTE")
            .build();

        UserDetails administrador = User.withDefaultPasswordEncoder()
            .username("administrador")
            .password("administrador")
            .roles("ADMINISTRADOR", "VISITANTE", "ESTUDANTE", "PROFESSOR")
            .build();

            return new InMemoryUserDetailsManager(visitante, estudante, professor, administrador);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (requests) -> {
            requests
                .requestMatchers("/").permitAll()
                .requestMatchers("visitante").hasRole("VISITANTE")
                .requestMatchers("estudante").hasRole("ESTUDANTE")
                .requestMatchers("professor").hasRole("PROFESSOR")
                .requestMatchers("administrador").hasRole("ADMINISTRADOR");
        } );

        http.formLogin(Customizer.withDefaults());

        return http.build();

    }

}

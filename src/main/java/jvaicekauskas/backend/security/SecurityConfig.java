package jvaicekauskas.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  // Nurodo, kad ši klasė yra konfigūracijos klasė, kuri naudoja Spring
// konteinerį nustatyti tam tikrus komponentus
public class SecurityConfig {

    // Šis metodas sukuria ir grąžina PasswordEncoder komponentą, kuris bus
    // naudojamas slaptažodžių šifravimui
    @Bean  // Nurodo, kad šis metodas grąžina Spring Bean, kuris bus valdomas Spring konteineryje
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Grąžina BCryptPasswordEncoder – p
        // opuliarų algoritmą, naudojamą slaptažodžių šifravimui
    }

    // Šis metodas sukuria ir grąžina AuthenticationManager, kuris bus naudojamas
    // autentifikacijos procesui
    @Bean  // Taip pat nurodo, kad šis metodas grąžina Spring Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();  // Grąžina AuthenticationManager iš A
        // uthenticationConfiguration
    }
}

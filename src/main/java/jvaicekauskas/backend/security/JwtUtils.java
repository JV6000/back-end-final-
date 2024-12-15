package jvaicekauskas.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    // Slaptas raktas, naudojamas JWT pasirašymui
    private final String SECRET = "Slaptasis_Raktas";

    // Nustatomas tokeno galiojimo laikas – 86400000 milisekundžių (24 valandos)
    private final long EXPIRATION_TIME = 86400000; // 1 diena = 86400000 milisekundžių

    // Metodas, generuojantis JWT (JSON Web Token) pagal pateiktą vartotojo vardą
    public String generateToken(String username) {
        return Jwts.builder()  // Sukuriamas JWT builderis
                .setSubject(username)  // Nustatomas subjekto (vartotojo) pavadinimas, kuris bus saugomas tokene
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))// Nustatomas tokeno
                // galiojimo laikas, kuris bus 24 valandos nuo sukūrimo
                .signWith(SignatureAlgorithm.HS512, SECRET)  // Pasirašomas tokenas naudojant
                // HS512 algoritmą ir slaptą raktą
                .compact();  // Tokenas užbaigiamas ir sukompiliuojamas į galutinį JWT
    }
}

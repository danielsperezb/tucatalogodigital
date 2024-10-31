package com.ieti.project.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "tucatalogodigitalkey"; // Corregir el nombre
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY); // Corregir el tipo de dato

    public String create(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("tucatalogodigital")
                .withIssuedAt(new Date()) // Cambiado de `withIssueAt` a `withIssuedAt`
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }

    public boolean isValid(String jwt){

        try{
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);

            return true;

        }catch (JWTVerificationException e){
            return false;
        }

    }


    public String getUsername(String jwt){
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }
}

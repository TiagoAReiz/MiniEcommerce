package tiago.Mini_Ecommerce.infrastructure.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tiago.Mini_Ecommerce.core.entities.UserEntity;

import java.time.Instant;
import java.util.Date;

@Service
public class jwtService {
    @Value("${app.secret.key}")
    private String secretKey;

    public String generateToken(UserEntity userEntity) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("Mini Ecommerce")
                    .withSubject(userEntity.getEmail())
                    .withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
                    .sign(Algorithm.HMAC256(secretKey.getBytes()));
        }catch (JWTCreationException e){
            throw new RuntimeException("Error while generating token",e);
        }


    }
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
            return JWT.require(algorithm)
                    .withIssuer("Mini Ecommerce")
                    .build()
                    .verify(token)
                    .getSubject();

        }
        catch (JWTVerificationException e){
            return "";
        }
    }
}

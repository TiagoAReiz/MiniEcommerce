package tiago.Mini_Ecommerce.infrastructure.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.Date;

public class jwtService {
    @Value("${app.secret.key}")
    private String secretKey;

    public String generateToken(String username){
        return JWT.create()
                .withIssuer("Mini Ecommerce")
                .withClaim("username",username)
                .withExpiresAt(Date.from(Instant.now().plusSeconds(3600)))
                .sign(Algorithm.HMAC256(secretKey.getBytes()));

    }
    public boolean validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Mini Ecommerce")
                    .build();
            verifier.verify(token);
            return true;
        }
        catch (JWTVerificationException e){
            return false;
        }
    }
}

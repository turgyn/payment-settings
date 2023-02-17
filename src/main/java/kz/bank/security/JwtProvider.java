package kz.bank.security;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.*;
import kz.bank.entity.User;
import org.aspectj.weaver.ConcreteTypeMunger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 27.04.2022
 */
@Component
public class JwtProvider implements Serializable {
    Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.secretRefresh}")
    private String secretRefresh;

    //retrieve username from jwt token
    public String generateAccessToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        final String accessToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(accessExpiration)
                .signWith(SignatureAlgorithm.HS512, secret)

                .compact();
        return accessToken;
    }

    public String generateRefreshToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        final String refreshToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(refreshExpiration)
                .signWith(SignatureAlgorithm.HS512, secretRefresh)
                .compact();
        return refreshToken;
    }

    public boolean validateAccessToken(@NonNull String token) {
        return validateToken(token, secret);
    }

    public boolean validateRefreshToken(@NonNull String token) {
        return validateToken(token, secretRefresh);
    }

    private boolean validateToken(@NonNull String token, @NonNull String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            logger.error("Token expired", expEx);
        } catch (UnsupportedJwtException unsEx) {
            logger.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
            logger.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
            logger.error("Invalid signature", sEx);
        } catch (Exception e) {
            logger.error("invalid token", e);
        }
        return false;
    }

    public Claims getAccessClaims(@NonNull String token) {
        return getClaims(token, secret);
    }

    public Claims getRefreshClaims(@NonNull String token) {
        return getClaims(token, secretRefresh);
    }

    private Claims getClaims(@NonNull String token, @NonNull String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String getUsernameFromToken(String token, int refresh) {
        String key=secret;
        if (refresh==1){
            key=secretRefresh;
        }

        return getClaimFromToken(token, Claims::getSubject, key);
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver,String secret) {
        final Claims claims = getClaims(token, secret );
        return claimsResolver.apply(claims);
    }
}

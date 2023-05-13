package dev.donjon.proyectopalomobackend.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import dev.donjon.proyectopalomobackend.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils
{
    private String jwtSigningKey = "secret";

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean hasClaim(String token, String claimName)
    {
        final Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(jwtSigningKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails, Usuario usuario)
    {
        Map<String, Object> claims = new HashMap<>();

        return createToken(claims, userDetails, usuario);
    }

    private String createToken(Map<String, Object> claims, UserDetails userDetails, Usuario usuario)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("authorities", userDetails.getAuthorities())
                .claim("nombre", usuario.getNombre())
                .claim("apellido", usuario.getApellido())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, jwtSigningKey)
                .compact();
    }

    public Boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

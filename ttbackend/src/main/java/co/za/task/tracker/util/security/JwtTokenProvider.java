package co.za.task.tracker.util.security;

import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + Integer.parseInt(propertyFetcher.getProperty(AppConstant.JWT_EXPIRATION_TIME)));

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, propertyFetcher.getProperty(AppConstant.JWT_SECRET))
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(propertyFetcher.getProperty(AppConstant.JWT_SECRET))
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(propertyFetcher.getProperty(AppConstant.JWT_SECRET)).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature --> ", ex);
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token --> ");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token --> ", ex);
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token --> ", ex);
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty --> ", ex);
        }
        return false;
    }
}

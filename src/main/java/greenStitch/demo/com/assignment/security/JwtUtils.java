package greenStitch.demo.com.assignment.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
	private static final String jwtSecret = "your-secret-key";
	private static final long jwtExpirationMillis = 3600000; // 1 hour

	public static String generateToken(String username) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + jwtExpirationMillis);

		return Jwts.builder().setSubject(username).setIssuedAt(now).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public static String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public static boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

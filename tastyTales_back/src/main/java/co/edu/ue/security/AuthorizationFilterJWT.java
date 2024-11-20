package co.edu.ue.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import static co.edu.ue.utils.Tools.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizationFilterJWT extends BasicAuthenticationFilter {

	public AuthorizationFilterJWT(AuthenticationManager authenticationManager) {
		super(authenticationManager);		
	}
 
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//super.doFilterInternal(request, response, chain);
		String header = request.getHeader(ENCABEZADO);
		System.out.println("encabezado "+header);
		if (header == null || !header.startsWith(PREFIJO_TOKEN)) {
			chain.doFilter(request, response);
			return;
		}
		//obtenemos los datos del usuario a partir del token
				UsernamePasswordAuthenticationToken authentication =
						getAuthentication(request);
				//la información del usuario se almacena en el contexto de seguridad
				//para que pueda ser utilizada por Spring security durante el
				//proceso de autorización
				SecurityContextHolder.getContext().setAuthentication(authentication);
				chain.doFilter(request, response);	
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication
	(HttpServletRequest request) {
		//el token viene en la cabecera de la petición
		String token = request.getHeader(ENCABEZADO);
		if (token != null) {
			 try {
			// Se procesa el token y se recupera el usuario y los roles.
			Claims claims=Jwts.parserBuilder()
					.setSigningKey(CLAVE.getBytes())
					.build()
					.parseClaimsJws(token.replace(PREFIJO_TOKEN, ""))
					.getBody();
			String user = claims.getSubject();
			Date expiration = claims.getExpiration();
 
              // Validar que el token no ha expirado
              if (expiration.before(new Date())) {
                  throw new JwtException("Token expirado");
              }
			
			List<String> authorities=(List<String>) claims.get("authorities");
			System.out.println("**************" + user);
			System.out.println("Autoridades: " + authorities);
			
			if (user != null) {
				//creamos el objeto con la información del usuario (usuario y roles)
				return new UsernamePasswordAuthenticationToken(user, null,
		                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
			}
			
			 } catch (JwtException e) {
	                // Manejo de errores de token
	                throw new RuntimeException("Token no válido: " + e.getMessage());
	            }
	        }
	        return null;
	    }

}

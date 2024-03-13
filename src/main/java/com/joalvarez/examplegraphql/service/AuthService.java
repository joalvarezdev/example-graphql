package com.joalvarez.examplegraphql.service;

import com.joalvarez.examplegraphql.constants.ErrorCode;
import com.joalvarez.examplegraphql.data.dto.UserDTO;
import com.joalvarez.examplegraphql.data.dto.generals.TokenResponseDTO;
import com.joalvarez.examplegraphql.data.dto.generals.UserLoginDTO;
import com.joalvarez.examplegraphql.data.model.User;
import com.joalvarez.examplegraphql.exception.generals.AuthException;
import com.joalvarez.examplegraphql.utils.Utils;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.joalvarez.examplegraphql.config.security.jwt.JwtConstants.*;

@Service
public class AuthService {

	private final AuthenticationManager authenticationManager;

	public AuthService(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public TokenResponseDTO login(UserLoginDTO dto) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
		Authentication authResult = null;

		try {
			authResult = this.authenticationManager.authenticate(authenticationToken);
		} catch (Exception e) {
			throw new AuthException(ErrorCode.USER_NOT_AUTHENTICATED.message());
		}

		var user = (User) authResult.getPrincipal();
		var roles = authResult.getAuthorities();

		var claims = Jwts.claims()
			.add("id_user", user.getId())
			.add("username", user.getUsername())
			.add("authorities", Utils.objectToJson(roles))
			.add("tenant", user.getUserId())
			.build();

		var currentDate = LocalDate.now();

		var token = Jwts.builder()
			.subject(user.getUsername())
			.claims(claims)
			.issuedAt(Date.from(currentDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
			.expiration(new Date(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli() + EXPIRATION_TIME))
			.signWith(SECRET_KEY)
			.compact();


		return new TokenResponseDTO(token, EXPIRATION_TIME, PREFIX_TOKEN);
	}

	public UserDTO register(UserDTO userDTO) {
		return new UserDTO();
	}
}
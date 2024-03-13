package com.joalvarez.examplegraphql.service;

import com.joalvarez.examplegraphql.constants.ErrorCode;
import com.joalvarez.examplegraphql.data.dao.UserDAO;
import com.joalvarez.examplegraphql.data.mapper.UserMapper;
import com.joalvarez.examplegraphql.data.model.User;
import com.joalvarez.examplegraphql.exception.generals.GenericException;
import com.joalvarez.examplegraphql.service.generals.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImplUserDetailsService extends GenericService<UserDAO, UserMapper> implements UserDetailsService {

	public ImplUserDetailsService(UserDAO userDAO, UserMapper mapper) {
		super(userDAO, mapper);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.dao.findByUsername(username)
			.orElseThrow(() -> new GenericException(
				HttpStatus.NOT_FOUND,
				ErrorCode.USER_OR_EMAIL_ALREADY_EXISTS
			));

		user.setAuthorities();

		return user;
	}
}

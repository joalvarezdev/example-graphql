package com.joalvarez.examplegraphql.data.dao;

import com.joalvarez.examplegraphql.data.dao.generals.GenericDAO;
import com.joalvarez.examplegraphql.data.model.User;
import com.joalvarez.examplegraphql.data.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDAO extends GenericDAO<UserRepository, User, Long> {

	public UserDAO(UserRepository repository) {
		super(repository);
	}

	public boolean existsUsernameOrEmail(String username, String email) {
		return this.repository.existsByUsernameOrEmail(username, email);
	}

	public Optional<User> findByUsername(String username) {
		return this.repository.findByUsername(username);
	}
}

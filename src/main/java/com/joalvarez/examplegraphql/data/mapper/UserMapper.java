package com.joalvarez.examplegraphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.examplegraphql.data.dto.UserDTO;
import com.joalvarez.examplegraphql.data.mapper.generals.BaseMapper;
import com.joalvarez.examplegraphql.data.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<UserDTO, User> {

	private final RoleMapper roleMapper;

	public UserMapper(ObjectMapper objectMapper, RoleMapper roleMapper) {
		super(objectMapper);
		this.roleMapper = roleMapper;
	}

	@Override
	public User fromDTO(UserDTO entity) {
		User user = super.fromDTO(entity);
		user.setPassword(entity.getPassword());

		user.setRoles(entity.getRoles().stream()
			.map(this.roleMapper::fromDTO)
			.toList());

		return user;
	}
}

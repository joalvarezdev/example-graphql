package com.joalvarez.examplegraphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.examplegraphql.data.dto.RoleDTO;
import com.joalvarez.examplegraphql.data.mapper.generals.BaseMapper;
import com.joalvarez.examplegraphql.data.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends BaseMapper<RoleDTO, Role> {

	public RoleMapper(ObjectMapper objectMapper) {
		super(objectMapper);
	}
}

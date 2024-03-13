package com.joalvarez.examplegraphql.service.interfaces;

import com.joalvarez.examplegraphql.service.generals.IBaseService;

import java.util.Optional;

public interface IRoleService<DTO> extends IBaseService<DTO, Long>{

	Optional<DTO> findByName(String name);
}

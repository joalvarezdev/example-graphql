package com.joalvarez.examplegraphql.service.interfaces;

import com.joalvarez.examplegraphql.service.generals.IBaseService;

public interface IUserService<DTO> extends IBaseService<DTO, Long>{

	DTO register(DTO dto);
}

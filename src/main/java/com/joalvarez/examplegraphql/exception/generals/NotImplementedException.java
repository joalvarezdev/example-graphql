package com.joalvarez.examplegraphql.exception.generals;

import com.joalvarez.examplegraphql.constants.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotImplementedException extends GenericException {

	public NotImplementedException() {
		super(HttpStatus.NOT_IMPLEMENTED, ErrorCode.NOT_IMPLEMENTED_ERROR);
	}
}
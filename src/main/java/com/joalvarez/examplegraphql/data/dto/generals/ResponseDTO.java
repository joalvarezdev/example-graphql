package com.joalvarez.examplegraphql.data.dto.generals;

import com.joalvarez.examplegraphql.constants.IResponse;

import java.util.List;

public record ResponseDTO (int code, String message, List<String> details) implements BaseDTO {}
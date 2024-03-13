package com.joalvarez.examplegraphql.data.dto.generals;

public record TokenResponseDTO(String token, Long expiresIn, String type) {
}

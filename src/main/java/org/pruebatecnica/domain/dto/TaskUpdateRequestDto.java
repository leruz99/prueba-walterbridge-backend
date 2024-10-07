package org.pruebatecnica.domain.dto;

public record TaskUpdateRequestDto(
        String title,
        String description,
        Boolean completed,
        String quote
) {
}

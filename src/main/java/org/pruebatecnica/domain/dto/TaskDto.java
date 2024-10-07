package org.pruebatecnica.domain.dto;

public record TaskDto(
        Long id,
        String title,
        String description,
        Boolean completed,
        String quote
) {
}

package com.weberth.qualitymanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public record NonConformityRequestDTO(
        @NotBlank(message = "Description is required")
        String description,

        @NotBlank(message = "Severity is required")
        String severity,

        String correctiveAction
) {
}

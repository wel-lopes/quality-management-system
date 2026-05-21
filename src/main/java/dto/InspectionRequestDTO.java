package com.weberth.qualitymanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record InspectionRequestDTO(
        @NotBlank(message = "Inspector name is required")
        String inspectorName,

        @NotBlank(message = "Product name is required")
        String productName,

        @NotBlank(message = "Status is required")
        String status,

        String observations,

        LocalDateTime inspectionDate
) {
}

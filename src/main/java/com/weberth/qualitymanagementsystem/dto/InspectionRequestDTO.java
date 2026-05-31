package com.weberth.qualitymanagementsystem.dto;

import com.weberth.qualitymanagementsystem.enums.InspectionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record InspectionRequestDTO(
        @NotBlank(message = "Inspector name is required")
        String inspectorName,

        @NotBlank(message = "Product name is required")
        String productName,

        @NotNull(message = "Status is required")
        InspectionStatus status,

        String observations,

        LocalDateTime inspectionDate
) {
}

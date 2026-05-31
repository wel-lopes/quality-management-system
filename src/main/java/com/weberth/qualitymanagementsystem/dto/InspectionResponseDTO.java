package com.weberth.qualitymanagementsystem.dto;

import com.weberth.qualitymanagementsystem.enums.InspectionStatus;

import java.time.LocalDateTime;

public record InspectionResponseDTO(
        Long id,
        String inspectorName,
        String productName,
        InspectionStatus status,
        String observations,
        LocalDateTime inspectionDate
) {
}

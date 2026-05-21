package com.weberth.qualitymanagementsystem.dto;

import java.time.LocalDateTime;

public record InspectionRequestDTO(
        String inspectorName,
        String productName,
        String status,
        String observations,
        LocalDateTime inspectionDate
) {
}

package com.weberth.qualitymanagementsystem.dto;

public record NonConformityResponseDTO(
        Long id,
        String description,
        String severity,
        String correctiveAction,
        Long inspectionId
){
}

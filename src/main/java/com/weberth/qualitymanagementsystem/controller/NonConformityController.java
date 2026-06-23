package com.weberth.qualitymanagementsystem.controller;

import com.weberth.qualitymanagementsystem.dto.NonConformityRequestDTO;
import com.weberth.qualitymanagementsystem.dto.NonConformityResponseDTO;
import com.weberth.qualitymanagementsystem.service.NonConformityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspections/{inspectionId}/non-conformities")
public class NonConformityController {

    private final NonConformityService nonConformityService;

    public NonConformityController(NonConformityService nonConformityService) {
        this.nonConformityService = nonConformityService;
    }

    @PostMapping
    public NonConformityResponseDTO createNonConformity(
            @PathVariable Long inspectionId,
            @Valid @RequestBody NonConformityRequestDTO dto
    ) {
        return nonConformityService.createNonConformity(inspectionId, dto);
    }

    @GetMapping
    public List<NonConformityResponseDTO> getNonConformitiesByInspection(
            @PathVariable Long inspectionId
    ) {
        return nonConformityService.getByInspection(inspectionId);
    }
}

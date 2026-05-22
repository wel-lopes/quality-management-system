package com.weberth.qualitymanagementsystem.controller;

import com.weberth.qualitymanagementsystem.dto.InspectionRequestDTO;
import com.weberth.qualitymanagementsystem.dto.InspectionResponseDTO;
import com.weberth.qualitymanagementsystem.entity.Inspection;
import com.weberth.qualitymanagementsystem.service.InspectionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/inspections")
@Tag(name = "Inspections", description = "Endpoints for inspection management")
public class InspectionController {
    private final InspectionService inspectionService;

    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @Operation(summary = "Create a new inspection")
    @PostMapping
    public InspectionResponseDTO createInspection(@Valid @RequestBody InspectionRequestDTO dto) {
        return inspectionService.saveInspection(dto);
    }

    @Operation(summary = "List all inspections")
    @GetMapping
    public List<InspectionResponseDTO> getAllInspections() {
        return inspectionService.getAllInspections();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find inspection by ID")
    public InspectionResponseDTO getInspectionById(@PathVariable Long id) {
        return inspectionService.getInspectionById(id);
    }
}

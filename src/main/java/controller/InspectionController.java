package com.weberth.qualitymanagementsystem.controller;

import com.weberth.qualitymanagementsystem.dto.InspectionRequestDTO;
import com.weberth.qualitymanagementsystem.dto.InspectionResponseDTO;
import com.weberth.qualitymanagementsystem.entity.Inspection;
import com.weberth.qualitymanagementsystem.service.InspectionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspections")
public class InspectionController {
    private final InspectionService inspectionService;

    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @PostMapping
    public InspectionResponseDTO createInspection(@Valid @RequestBody InspectionRequestDTO dto) {
        return inspectionService.saveInspection(dto);
    }

    @GetMapping
    public List<InspectionResponseDTO> getAllInspections() {
        return inspectionService.getAllInspections();
    }
}

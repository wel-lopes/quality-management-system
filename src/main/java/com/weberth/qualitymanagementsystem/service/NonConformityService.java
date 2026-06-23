package com.weberth.qualitymanagementsystem.service;

import com.weberth.qualitymanagementsystem.dto.NonConformityRequestDTO;
import com.weberth.qualitymanagementsystem.dto.NonConformityResponseDTO;
import com.weberth.qualitymanagementsystem.entity.Inspection;
import com.weberth.qualitymanagementsystem.entity.NonConformity;
import com.weberth.qualitymanagementsystem.exception.InspectionNotFoundException;
import com.weberth.qualitymanagementsystem.repository.NonConformityRepository;
import com.weberth.qualitymanagementsystem.repository.InspectionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NonConformityService {
    private final NonConformityRepository nonConformityRepository;
    private final InspectionRepository inspectionRepository;

    public NonConformityService(
            NonConformityRepository nonConformityRepository,
            InspectionRepository inspectionRepository
    ){
        this.nonConformityRepository = nonConformityRepository;
        this.inspectionRepository = inspectionRepository;
    }

    public NonConformityResponseDTO createNonConformity(Long inspectionId, NonConformityRequestDTO dto){
        Inspection inspection = inspectionRepository.findById(inspectionId)
                .orElseThrow(() -> new InspectionNotFoundException(inspectionId));
        NonConformity nonConformity = NonConformity.builder()
                .description(dto.description())
                .severity(dto.severity())
                .correctiveAction(dto.correctiveAction())
                .inspection(inspection)
                .build();

        NonConformity savedNonConformity = nonConformityRepository.save(nonConformity);

        return toResponseDTO(savedNonConformity);
    }

    private NonConformityResponseDTO toResponseDTO(NonConformity nonConformity) {
        return new NonConformityResponseDTO(
                nonConformity.getId(),
                nonConformity.getDescription(),
                nonConformity.getSeverity(),
                nonConformity.getCorrectiveAction(),
                nonConformity.getInspection().getId()
        );
    }

    public List<NonConformityResponseDTO> getByInspection(Long inspectionId) {
        Inspection inspection = inspectionRepository.findById(inspectionId)
                .orElseThrow(() -> new InspectionNotFoundException(inspectionId));

        List<NonConformity> nonConformities =
                nonConformityRepository.findByInspectionId(inspectionId);
        List<NonConformityResponseDTO> response = new ArrayList<>();

        for (NonConformity nonConformity : nonConformities) {
            response.add(toResponseDTO(nonConformity));
        }

        return response;
    }
}

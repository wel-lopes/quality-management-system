package com.weberth.qualitymanagementsystem.service;

import com.weberth.qualitymanagementsystem.dto.InspectionRequestDTO;
import com.weberth.qualitymanagementsystem.dto.InspectionResponseDTO;
import com.weberth.qualitymanagementsystem.entity.Inspection;
import com.weberth.qualitymanagementsystem.repository.InspectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspectionService {

    private final InspectionRepository inspectionRepository;

    public InspectionService(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    public InspectionResponseDTO saveInspection(InspectionRequestDTO dto) {

        Inspection inspection = Inspection.builder()
                .inspectorName(dto.inspectorName())
                .productName(dto.productName())
                .status(dto.status())
                .observations(dto.observations())
                .inspectionDate(dto.inspectionDate())
                .build();

        Inspection savedInspection = inspectionRepository.save(inspection);

        return new InspectionResponseDTO(
                savedInspection.getId(),
                savedInspection.getInspectorName(),
                savedInspection.getProductName(),
                savedInspection.getStatus(),
                savedInspection.getObservations(),
                savedInspection.getInspectionDate()
        );
    }

    public List<InspectionResponseDTO> getAllInspections() {

        return inspectionRepository.findAll()
                .stream()
                .map(inspection -> new InspectionResponseDTO(
                        inspection.getId(),
                        inspection.getInspectorName(),
                        inspection.getProductName(),
                        inspection.getStatus(),
                        inspection.getObservations(),
                        inspection.getInspectionDate()
                ))
                .toList();
    }
}
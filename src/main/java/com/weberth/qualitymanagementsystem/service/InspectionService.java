package com.weberth.qualitymanagementsystem.service;

import com.weberth.qualitymanagementsystem.dto.InspectionRequestDTO;
import com.weberth.qualitymanagementsystem.dto.InspectionResponseDTO;
import com.weberth.qualitymanagementsystem.entity.Inspection;
import com.weberth.qualitymanagementsystem.exception.InspectionNotFoundException;
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

        return toResponseDTO(savedInspection);
    }

    public List<InspectionResponseDTO> getAllInspections() {
        return inspectionRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public InspectionResponseDTO getInspectionById(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException(id));

        return toResponseDTO(inspection);
    }

    public InspectionResponseDTO updateInspection(Long id, InspectionRequestDTO dto) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException(id));

        inspection.setInspectorName(dto.inspectorName());
        inspection.setProductName(dto.productName());
        inspection.setStatus(dto.status());
        inspection.setObservations(dto.observations());
        inspection.setInspectionDate(dto.inspectionDate());

        Inspection updatedInspection = inspectionRepository.save(inspection);

        return toResponseDTO(updatedInspection);
    }

    public void deleteInspection(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException(id));

        inspectionRepository.delete(inspection);
    }

    private InspectionResponseDTO toResponseDTO(Inspection inspection) {
        return new InspectionResponseDTO(
                inspection.getId(),
                inspection.getInspectorName(),
                inspection.getProductName(),
                inspection.getStatus(),
                inspection.getObservations(),
                inspection.getInspectionDate()
        );
    }
}
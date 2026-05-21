package com.weberth.qualitymanagementsystem.service;

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

    public Inspection saveInspection(Inspection inspection) {
        return inspectionRepository.save(inspection);
    }

    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }
}

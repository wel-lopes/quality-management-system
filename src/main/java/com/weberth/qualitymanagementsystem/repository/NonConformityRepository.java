package com.weberth.qualitymanagementsystem.repository;

import com.weberth.qualitymanagementsystem.entity.NonConformity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NonConformityRepository extends JpaRepository<NonConformity, Long> {
    List<NonConformity> findByInspectionId(Long inspectionId);
}

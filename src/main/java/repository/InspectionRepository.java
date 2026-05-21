package com.weberth.qualitymanagementsystem.repository;

import com.weberth.qualitymanagementsystem.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
}

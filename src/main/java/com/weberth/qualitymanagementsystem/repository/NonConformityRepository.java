package com.weberth.qualitymanagementsystem.repository;

import com.weberth.qualitymanagementsystem.entity.NonConformity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonConformityRepository extends JpaRepository<NonConformity, Long> {
}

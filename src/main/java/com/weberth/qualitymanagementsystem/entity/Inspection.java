package com.weberth.qualitymanagementsystem.entity;

import com.weberth.qualitymanagementsystem.enums.InspectionStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "inspections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inspectorName;

    private String productName;

    @Enumerated(EnumType.STRING)
    private InspectionStatus status;

    private String observations;

    private LocalDateTime inspectionDate;

    @OneToMany(mappedBy = "inspection")
    @JsonIgnore
    private List<NonConformity> nonConformities;
}
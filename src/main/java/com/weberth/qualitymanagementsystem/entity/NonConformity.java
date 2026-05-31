package com.weberth.qualitymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "non_conformities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NonConformity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String severity;

    private String correctiveAction;

    @ManyToOne
    @JoinColumn(name = "inspection_id")
    private Inspection inspection;
}
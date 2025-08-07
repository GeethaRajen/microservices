package com.geetha.candidate.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long candidateId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(length = 12, nullable = false)
    private String aadhaar;

    @Column(nullable = false)
    private String party;

    @Column(nullable = false)
    private Long electionId;
}
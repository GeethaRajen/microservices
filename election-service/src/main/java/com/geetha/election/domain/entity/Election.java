package com.geetha.election.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long electionId;

    @Column(length = 30, nullable = false)
    private String electionName;

    @Column(length = 30, nullable = false)
    private String state;

    private List<Integer> candidates;
}
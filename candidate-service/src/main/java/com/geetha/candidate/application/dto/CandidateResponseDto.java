package com.geetha.candidate.application.dto;

import lombok.Data;

@Data
public class CandidateResponseDto {
    private Long candidateId;
    private String name;
    private int age;
    private String partyName;
    private Long electionId;
}
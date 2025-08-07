package com.geetha.candidate.application.mapper;

import com.geetha.candidate.application.dto.CandidateRequestDto;
import com.geetha.candidate.application.dto.CandidateResponseDto;
import com.geetha.candidate.domain.entity.Candidate;

public final class CandidateMapper {

    public static Candidate toEntity(CandidateRequestDto dto){
        Candidate candidate = new Candidate();
        candidate.setAadhaar(dto.aadhaar());
        candidate.setAge(dto.age());
        candidate.setName(dto.name());
        candidate.setParty(dto.party());
        candidate.setElectionId(dto.electionId());
        return candidate;
    }

    public static CandidateResponseDto toDto(Candidate candidate){
        CandidateResponseDto dto = new CandidateResponseDto();
        dto.setCandidateId(candidate.getCandidateId());
        dto.setAge(candidate.getAge());
        dto.setName(candidate.getName());
        dto.setPartyName(candidate.getParty());
        dto.setElectionId(candidate.getElectionId());
        return dto;
    }
}

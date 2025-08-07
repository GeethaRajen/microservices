package com.geetha.candidate.domain.service;

import com.geetha.candidate.application.dto.CandidateRequestDto;
import com.geetha.candidate.application.dto.CandidateResponseDto;
import com.geetha.candidate.application.dto.ElectionResponseDto;

import java.util.List;

public interface CandidateService {
    CandidateResponseDto addCandidate(CandidateRequestDto dto);

    public CandidateResponseDto getCandidate(Long candidateId);

    List<CandidateResponseDto> getCandidatesForElection(Long electionId);

    List<ElectionResponseDto> getScheduledElections();
}

package com.geetha.election.domain.service;

import com.geetha.election.application.dto.CandidateDto;
import com.geetha.election.application.dto.ElectionDto;
import com.geetha.election.application.dto.ElectionRequestDto;

import java.util.List;

public interface ElectionService {
    ElectionRequestDto addElection(ElectionRequestDto dto);

    List<CandidateDto> getCandidates(Long electionId);

    List<ElectionDto> getAllElections();

    ElectionDto getElection(Long electionId);
}

package com.geetha.election.application.dto;

import java.util.List;

public record ElectionDto(
        Long electionId,
        String name,
        String state,
        List<CandidateDto> candidateDtoList){}
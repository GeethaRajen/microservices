package com.geetha.election.client;

import com.geetha.election.application.dto.CandidateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CANDIDATE-SERVICE")
public interface CandidateClient {

    @GetMapping("/candidates/elections/{id}")
    ResponseEntity<List<CandidateDto>> getCandidatesForElection(
            @PathVariable("id") Long electionId);
}

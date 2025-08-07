package com.geetha.candidate.application.controller;

import com.geetha.candidate.application.dto.CandidateRequestDto;
import com.geetha.candidate.application.dto.CandidateResponseDto;
import com.geetha.candidate.application.dto.ElectionResponseDto;
import com.geetha.candidate.domain.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    CandidateService service;

    public CandidateController(CandidateService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CandidateResponseDto> addCandidate(CandidateRequestDto dto){
        return new ResponseEntity<>(service.addCandidate(dto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CandidateResponseDto> getCandidate(@PathVariable("id") Long candidateId){
        return new ResponseEntity<>(service.getCandidate(candidateId), HttpStatus.OK);
    }

    @GetMapping("/elections/{id}")
    public ResponseEntity<List<CandidateResponseDto>> getCandidatesForElection(
                        @PathVariable("id") Long electionId){
        return new ResponseEntity<>(service.getCandidatesForElection(electionId), HttpStatus.OK);
    }

    @GetMapping("/elections")
    public ResponseEntity<List<ElectionResponseDto>> getScheduledElections(){
        return new ResponseEntity<>(service.getScheduledElections(), HttpStatus.OK);
    }
}
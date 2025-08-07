package com.geetha.election.application.controller;

import com.geetha.election.application.dto.CandidateDto;
import com.geetha.election.application.dto.ElectionDto;
import com.geetha.election.application.dto.ElectionRequestDto;
import com.geetha.election.domain.service.ElectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/elections")
public class ElectionController {

    private final ElectionService service;

    public ElectionController(ElectionService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ElectionRequestDto> createElection(@RequestBody @Valid ElectionRequestDto dto){
        return new ResponseEntity<>(service.addElection(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ElectionDto>> getAllElections(){
        return new ResponseEntity<>(service.getAllElections(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ElectionDto> getElection(@PathVariable("id") Long electionId){
        return new ResponseEntity<>(service.getElection(electionId),HttpStatus.OK);
    }

    @GetMapping("/candidates/{id}")
    public ResponseEntity<List<CandidateDto>> getCandidates(@PathVariable("id") Long electionId){
        return new ResponseEntity<>(service.getCandidates(electionId),HttpStatus.OK);
    }

}
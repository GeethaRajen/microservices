package com.geetha.candidate.domain.service;

import com.geetha.candidate.application.dto.CandidateRequestDto;
import com.geetha.candidate.application.dto.CandidateResponseDto;
import com.geetha.candidate.application.dto.ElectionResponseDto;
import com.geetha.candidate.application.mapper.CandidateMapper;
import com.geetha.candidate.client.ElectionClient;
import com.geetha.candidate.domain.entity.Candidate;
import com.geetha.candidate.domain.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final ElectionClient client;
    private final  CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository, ElectionClient client){
        this.repository = repository;
        this.client=client;
    }

    @Override
    public CandidateResponseDto addCandidate(CandidateRequestDto dto) {
        Candidate candidate = CandidateMapper.toEntity(dto);
        return CandidateMapper.toDto(repository.save(candidate));
    }

    @Override
    public CandidateResponseDto getCandidate(Long candidateId) {
        return CandidateMapper.toDto(repository.findById(candidateId)
                              .orElseThrow(() -> new RuntimeException("Candidate not found")));
    }

    @Override
    public List<CandidateResponseDto> getCandidatesForElection(Long electionId) {
        List<Candidate> candidateList = repository.findByElectionId(electionId);
        return candidateList.stream().map(CandidateMapper::toDto).toList();
    }

    @Override
    public List<ElectionResponseDto> getScheduledElections(){
        return client.getAllElections().getBody();
    }
}
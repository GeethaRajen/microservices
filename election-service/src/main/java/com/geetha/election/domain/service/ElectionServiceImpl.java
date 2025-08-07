package com.geetha.election.domain.service;

import com.geetha.election.application.dto.CandidateDto;
import com.geetha.election.application.dto.ElectionDto;
import com.geetha.election.application.dto.ElectionRequestDto;
import com.geetha.election.client.CandidateClient;
import com.geetha.election.domain.entity.Election;
import com.geetha.election.application.mapper.ElectionMapper;
import com.geetha.election.domain.repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository repo;

    private final CandidateClient client;

    public ElectionServiceImpl(ElectionRepository repo, CandidateClient client){
        this.repo = repo;
        this.client = client;
    }

    @Override
    public ElectionRequestDto addElection(ElectionRequestDto dto) {
        Election election = ElectionMapper.requestDtoToEntity(dto);
        Election savedElection = repo.save(election);
        return ElectionMapper.toRequestDto(savedElection);
    }

    @Override
    public List<CandidateDto> getCandidates(Long electionId) {
        return client.getCandidatesForElection(electionId).getBody();
    }

    @Override
    public List<ElectionDto> getAllElections(){
        List<Election> electionsList = repo.findAll();
        return electionsList.stream().map(ElectionMapper::toDto).toList();
    }

    @Override
    public ElectionDto getElection(Long electionId){
        return ElectionMapper.toDto(repo.findById(electionId)
                .orElseThrow(() -> new RuntimeException("Election object not found")));
    }
}
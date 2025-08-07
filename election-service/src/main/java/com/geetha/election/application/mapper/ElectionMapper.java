package com.geetha.election.application.mapper;

import com.geetha.election.application.dto.ElectionDto;
import com.geetha.election.application.dto.ElectionRequestDto;
import com.geetha.election.domain.entity.Election;

import java.util.ArrayList;

public final class ElectionMapper {

    public static ElectionDto toDto(Election election) {
        return new ElectionDto(election.getElectionId(), election.getElectionName(),
                                          election.getState(), new ArrayList<>());
    }

    public static ElectionRequestDto toRequestDto(Election election) {
        return new ElectionRequestDto(election.getElectionId(), election.getElectionName(),
                election.getState());
    }

    public static Election requestDtoToEntity(ElectionRequestDto dto){
        Election election = new Election();
        election.setElectionName(dto.name());
        election.setState(dto.state());
        return election;
    }
}
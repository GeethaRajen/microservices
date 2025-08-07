package com.geetha.candidate.client;

import com.geetha.candidate.application.dto.ElectionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient("ELECTION-SERVICE")
public interface ElectionClient {
    @GetMapping("/elections")
    public ResponseEntity<List<ElectionResponseDto>> getAllElections();
}

package com.geetha.election.application.dto;

import jakarta.validation.constraints.NotBlank;

public record ElectionRequestDto(
        Long id,
        @NotBlank(message = "Election Name cannot be blank") String name,
        @NotBlank(message = "State cannot be blank") String state)
{}

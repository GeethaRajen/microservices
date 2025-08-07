package com.geetha.candidate.application.dto;

public record ElectionResponseDto(Long electionId,
                                  String name,
                                  String state)
{ }
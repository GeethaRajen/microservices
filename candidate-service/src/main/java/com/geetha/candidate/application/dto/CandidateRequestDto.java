package com.geetha.candidate.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CandidateRequestDto(
        @NotBlank String name,

        @Min(value = 18, message = "You are not eligible to contest in election")
        @Max(value=90, message = "You are too old to contest in election")
        int age,

        @Size(min = 12, max = 12, message = "Aadhaar should be 12 digits")
        String aadhaar,
        @NotBlank String party,
        @NotBlank Long electionId) {
}

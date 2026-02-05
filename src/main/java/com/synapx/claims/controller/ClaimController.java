package com.synapx.claims.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synapx.claims.dto.ClaimRequestDTO;
import com.synapx.claims.dto.ClaimResponseDTO;
import com.synapx.claims.service.ClaimProcessingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")
@Validated
public class ClaimController {

    private final ClaimProcessingService claimProcessingService;

    public ClaimController(ClaimProcessingService claimProcessingService) {
        this.claimProcessingService = claimProcessingService;
    }

    @PostMapping("/process")
    public ClaimResponseDTO processClaim(@Valid @RequestBody ClaimRequestDTO request) {
        return claimProcessingService.processClaim(request);
    }
}

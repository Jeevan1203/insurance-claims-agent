package com.synapx.claims.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.synapx.claims.dto.ClaimRequestDTO;
import com.synapx.claims.dto.ClaimResponseDTO;

@Service
public class ClaimProcessingService {

    public ClaimResponseDTO processClaim(ClaimRequestDTO request) {

        ClaimResponseDTO response = new ClaimResponseDTO();

        // Extract Fields
        Map<String, Object> extractedFields = new HashMap<>();
        extractedFields.put("policyNumber", request.getPolicyNumber());
        extractedFields.put("policyHolder", request.getPolicyHolder());
        extractedFields.put("dateOfLoss", request.getDateOfLoss());
        extractedFields.put("location", request.getLocation());
        extractedFields.put("description", request.getDescription());
        extractedFields.put("claimType", request.getClaimType());
        extractedFields.put("estimatedDamage", request.getEstimatedDamage());

        response.setExtractedFields(extractedFields);

        // Missing Fields Check
        List<String> missingFields = new ArrayList<>();

        if (isBlank(request.getPolicyNumber()))
            missingFields.add("policyNumber");

        if (isBlank(request.getPolicyHolder()))
            missingFields.add("policyHolder");

        if (isBlank(request.getDateOfLoss()))
            missingFields.add("dateOfLoss");

        if (isBlank(request.getLocation()))
            missingFields.add("location");

        if (isBlank(request.getDescription()))
            missingFields.add("description");

        if (isBlank(request.getClaimType()))
            missingFields.add("claimType");

        if (request.getEstimatedDamage() == null)
            missingFields.add("estimatedDamage");

        response.setMissingFields(missingFields);

        // Routing Rules

        if (!missingFields.isEmpty()) {
            response.setRecommendedRoute("Manual Review");
            response.setReasoning("Mandatory fields are missing: " + missingFields);
            return response;
        }

        String description = request.getDescription().toLowerCase();
        if (description.contains("fraud")
                || description.contains("staged")
                || description.contains("inconsistent")) {

            response.setRecommendedRoute("Investigation Flag");
            response.setReasoning("Suspicious keywords detected in description");
            return response;
        }

        if ("injury".equalsIgnoreCase(request.getClaimType())) {
            response.setRecommendedRoute("Specialist Queue");
            response.setReasoning("Claim involves injury");
            return response;
        }

        if (request.getEstimatedDamage() < 25000) {
            response.setRecommendedRoute("Fast-track");
            response.setReasoning("Estimated damage is below 25,000");
            return response;
        }

        response.setRecommendedRoute("Standard Review");
        response.setReasoning("Claim requires standard processing");

        return response;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

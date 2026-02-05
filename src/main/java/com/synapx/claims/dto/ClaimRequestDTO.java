package com.synapx.claims.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClaimRequestDTO {

    @NotBlank
    private String policyNumber;

    @NotNull
    private String policyHolder;

    @NotBlank
    private String dateOfLoss;

    @NotNull
    private String location;

    @NotBlank
    private String description;

    @NotBlank
    private String claimType;

    @NotNull
    private Integer estimatedDamage;

    // Getters and Setters

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(String dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public Integer getEstimatedDamage() {
        return estimatedDamage;
    }

    public void setEstimatedDamage(Integer estimatedDamage) {
        this.estimatedDamage = estimatedDamage;
    }
}

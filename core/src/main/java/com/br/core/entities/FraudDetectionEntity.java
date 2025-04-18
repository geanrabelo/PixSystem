package com.br.core.entities;

import com.br.core.enums.FraudDetectionEnum;

import java.util.List;
import java.util.UUID;

public class FraudDetectionEntity {

    public FraudDetectionEntity(TransactionEntity transactionEntity, Double riskScore, List<String> indicators, String reviewNotes){
        this.id = UUID.randomUUID();
        this.transactionEntity = transactionEntity;
        this.riskScore = riskScore;
        this.indicators = indicators;
        this.fraudDetectionEnum = null;
        this.reviewed = null;
        this.reviewNotes = reviewNotes;
    }

    public FraudDetectionEntity(UUID id, TransactionEntity transactionEntity, Double riskScore, List<String> indicators, FraudDetectionEnum fraudDetectionEnum, Boolean reviewed, String reviewNotes) {
        this.id = id;
        this.transactionEntity = transactionEntity;
        this.riskScore = riskScore;
        this.indicators = indicators;
        this.fraudDetectionEnum = fraudDetectionEnum;
        this.reviewed = reviewed;
        this.reviewNotes = reviewNotes;
    }

    private UUID id;
    private TransactionEntity transactionEntity;
    private Double riskScore;
    private List<String> indicators;
    private FraudDetectionEnum fraudDetectionEnum;
    private Boolean reviewed;
    private String reviewNotes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TransactionEntity getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(TransactionEntity transactionEntity) {
        this.transactionEntity = transactionEntity;
    }

    public Double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Double riskScore) {
        this.riskScore = riskScore;
    }

    public List<String> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<String> indicators) {
        this.indicators = indicators;
    }

    public FraudDetectionEnum getFraudDetectionEnum() {
        return fraudDetectionEnum;
    }

    public void setFraudDetectionEnum(FraudDetectionEnum fraudDetectionEnum) {
        this.fraudDetectionEnum = fraudDetectionEnum;
    }

    public Boolean getReviewed() {
        return reviewed;
    }

    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }

    public String getReviewNotes() {
        return reviewNotes;
    }

    public void setReviewNotes(String reviewNotes) {
        this.reviewNotes = reviewNotes;
    }

    public static class FraudDetectionBuilder{
        private UUID id;
        private TransactionEntity transactionEntity;
        private Double riskScore;
        private List<String> indicators;
        private FraudDetectionEnum fraudDetectionEnum;
        private Boolean reviewed;
        private String reviewNotes;

        public FraudDetectionBuilder builder(){
            return new FraudDetectionBuilder();
        }

        public FraudDetectionBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public FraudDetectionBuilder transactionEntity(TransactionEntity transactionEntity) {
            this.transactionEntity = transactionEntity;
            return this;
        }

        public FraudDetectionBuilder riskScore(Double riskScore) {
            this.riskScore = riskScore;
            return this;
        }

        public FraudDetectionBuilder indicators(List<String> indicators) {
            this.indicators = indicators;
            return this;
        }

        public FraudDetectionBuilder fraudDetectionEnum(FraudDetectionEnum fraudDetectionEnum) {
            this.fraudDetectionEnum = fraudDetectionEnum;
            return this;
        }

        public FraudDetectionBuilder reviewed(Boolean reviewed) {
            this.reviewed = reviewed;
            return this;
        }

        public FraudDetectionBuilder reviewNotes(String reviewNotes) {
            this.reviewNotes = reviewNotes;
            return this;
        }

        public FraudDetectionEntity build(){
            return new FraudDetectionEntity(this.id, this.transactionEntity, this.riskScore, this.indicators, this.fraudDetectionEnum, this.reviewed, this.reviewNotes);
        }
    }
}

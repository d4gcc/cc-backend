package com.chunkiechunks.service.dto;

public class SubFamilyDTO {

    private Long id;
    private String subFamilyId;
    private String ppp;
    private String recommendation;
    private String target;
    private String odd;
    private String cycleDeVie;
    private Long familyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubFamilyId() {
        return subFamilyId;
    }

    public void setSubFamilyId(String subFamilyId) {
        this.subFamilyId = subFamilyId;
    }

    public String getPpp() {
        return ppp;
    }

    public void setPpp(String ppp) {
        this.ppp = ppp;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public String getCycleDeVie() {
        return cycleDeVie;
    }

    public void setCycleDeVie(String cycleDeVie) {
        this.cycleDeVie = cycleDeVie;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }
}

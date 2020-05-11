package com.akoca.mvc.domain.test;

public class OrganizationRegistration {

    private String organizationName;
    private String country;
    private String turnover;
    private String type;
    private String since;
    private boolean registeredPreviously = true;
    private String like;
    private String[] optionalServices;
    private String[] premiumServices;
    private String overseasOperations;
    private String employeeStrength;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public boolean isRegisteredPreviously() {
        return registeredPreviously;
    }

    public void setRegisteredPreviously(boolean registeredPreviously) {
        this.registeredPreviously = registeredPreviously;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String[] getOptionalServices() {
        return optionalServices;
    }

    public void setOptionalServices(String[] optionalServices) {
        this.optionalServices = optionalServices;
    }

    public String[] getPremiumServices() {
        return premiumServices;
    }

    public void setPremiumServices(String[] premiumServices) {
        this.premiumServices = premiumServices;
    }

    public String getOverseasOperations() {
        return overseasOperations;
    }

    public void setOverseasOperations(String overSeasOperations) {
        this.overseasOperations = overSeasOperations;
    }

    public String getEmployeeStrength() {
        return employeeStrength;
    }

    public void setEmployeeStrength(String employeeStrength) {
        this.employeeStrength = employeeStrength;
    }
}
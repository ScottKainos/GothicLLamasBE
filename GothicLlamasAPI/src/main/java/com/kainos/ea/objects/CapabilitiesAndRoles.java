package com.kainos.ea.objects;

public class CapabilitiesAndRoles {
    private String capability;
    private String bandLevel;
    private String jobRole;
    private String jobDescription;
    private String linkToFullDescription;

    public CapabilitiesAndRoles() {
    }

    public CapabilitiesAndRoles(String capability, String bandLevel, String jobRole, String jobDescription, String linkToFullDescription) {
        this.capability = capability;
        this.bandLevel = bandLevel;
        this.jobRole = jobRole;
        this.jobDescription = jobDescription;
        this.linkToFullDescription = linkToFullDescription;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getBandLevel() {
        return bandLevel;
    }

    public void setBandLevel(String bandLevel) {
        this.bandLevel = bandLevel;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLinkToFullDescription() {
        return linkToFullDescription;
    }

    public void setLinkToFullDescription(String linkToFullDescription) {
        this.linkToFullDescription = linkToFullDescription;
    }
}
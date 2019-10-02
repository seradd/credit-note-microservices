package com.serad.creditnote.notificationservice.model;

public class SmsReq {

    private String fullName;
    private String phoneNumber;
    private Double limitInfo;
    private Boolean approvalStatus;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getLimitInfo() {
        return limitInfo;
    }

    public void setLimitInfo(Double limitInfo) {
        this.limitInfo = limitInfo;
    }

    public Boolean getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}

package com.serad.creditnote.customerservice.models;

import com.serad.creditnote.customerservice.enumaration.ApprovalStatus;

public class CreditResult {
    private ApprovalStatus approvalStatus;
    private Double limitInfo;

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Double getLimitInfo() {
        return limitInfo;
    }

    public void setLimitInfo(Double limitInfo) {
        this.limitInfo = limitInfo;
    }
}

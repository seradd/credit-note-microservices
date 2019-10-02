package com.serad.creditnote.customerservice.models;

import com.serad.creditnote.customerservice.enumaration.ApprovalStatus;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditApplications")
public class CreditApplications extends BaseEntity{

    private String tckn;
    private ApprovalStatus approvalStatus;
    private Double limit;

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }
}

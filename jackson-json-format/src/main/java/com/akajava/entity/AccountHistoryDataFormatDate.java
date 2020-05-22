/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.logicbig.example.DateHandler;

import java.util.Date;

/**
 * Bean class for AccountHistoryData.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "accountHistoryDataArray")
public class AccountHistoryDataFormatDate {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date reportedDate;
    private String suitFiledStatus;
    private String writtenoffAndSettledStatus;
    private long creditLimit;
    private long cashLimit;
    private long highCreditAmount;
    private long currentBalance;
    private long amountOverdue;

    /**
     * @return the reportedDate
     */
    public Date getReportedDate() {
        return reportedDate;
    }

    /**
     * @param reportedDate the reportedDate to set
     */
    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    /**
     * @return the suitFiledStatus
     */
    public String getSuitFiledStatus() {
        return suitFiledStatus;
    }

    /**
     * @param suitFiledStatus the suitFiledStatus to set
     */
    public void setSuitFiledStatus(String suitFiledStatus) {
        this.suitFiledStatus = suitFiledStatus;
    }

    /**
     * @return the writtenoffAndSettledStatus
     */
    public String getWrittenoffAndSettledStatus() {
        return writtenoffAndSettledStatus;
    }

    /**
     * @param writtenoffAndSettledStatus the writtenoffAndSettledStatus to set
     */
    public void setWrittenoffAndSettledStatus(String writtenoffAndSettledStatus) {
        this.writtenoffAndSettledStatus = writtenoffAndSettledStatus;
    }

    /**
     * @return the creditLimit
     */
    public long getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the cashLimit
     */
    public long getCashLimit() {
        return cashLimit;
    }

    /**
     * @param cashLimit the cashLimit to set
     */
    public void setCashLimit(long cashLimit) {
        this.cashLimit = cashLimit;
    }

    /**
     * @return the highCreditAmount
     */
    public long getHighCreditAmount() {
        return highCreditAmount;
    }

    /**
     * @param highCreditAmount the highCreditAmount to set
     */
    public void setHighCreditAmount(long highCreditAmount) {
        this.highCreditAmount = highCreditAmount;
    }

    /**
     * @return the currentBalance
     */
    public long getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * @return the amountOverdue
     */
    public long getAmountOverdue() {
        return amountOverdue;
    }

    /**
     * @param amountOverdue the amountOverdue to set
     */
    public void setAmountOverdue(long amountOverdue) {
        this.amountOverdue = amountOverdue;
    }
}

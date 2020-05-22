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
import java.util.StringJoiner;

/**
 * Beans class for EmploymentData.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "employmentData")
public class EmploymentDataFormatDate extends SubjectField {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date reportedDate;
    private String occupationCode;
    private long income;
    private String netGrossIncomeIndicator;
    private String incomeFreqIndicator;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date errCodeEntryDate;
    private String errCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date cibilRemarksCodeEntryDate;
    private String cibilRemarksCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date errRemarksCodeEntryDate;
    private String errRemarksCode1;
    private String errRemarksCode2;
    private String enrichMode;
    private String enrichMemberCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date enrichDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date suppressionDate;

    /**
     * to get reportedDate.
     *
     * @return reportedDate
     */
    public Date getReportedDate() {
        return reportedDate;
    }

    /**
     * to set reportedDate.
     *
     * @param reportedDate
     */
    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    /**
     * to get occupationCode.
     *
     * @return occupationCode
     */
    public String getOccupationCode() {
        return occupationCode;
    }

    /**
     * to set occupationCode.
     *
     * @param occupationCode
     */
    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    /**
     * to get income.
     *
     * @return income
     */
    public long getIncome() {
        return income;
    }

    /**
     * to set income.
     *
     * @param income
     */
    public void setIncome(long income) {
        this.income = income;
    }

    /**
     * to get netGrossIncomeIndicator.
     *
     * @return netGrossIncomeIndicator
     */
    String getNetGrossIncomeIndicator() {
        return netGrossIncomeIndicator;
    }

    /**
     * to set netGrossIncomeIndicator.
     *
     * @param netGrossIncomeIndicator
     */
    public void setNetGrossIncomeIndicator(String netGrossIncomeIndicator) {
        this.netGrossIncomeIndicator = netGrossIncomeIndicator;
    }

    /**
     * to get incomeFreqIndicator.
     *
     * @return incomeFreqIndicator
     */
    String getIncomeFreqIndicator() {
        return incomeFreqIndicator;
    }

    /**
     * to set incomeFreqIndicator.
     *
     * @param incomeFreqIndicator
     */
    public void setIncomeFreqIndicator(String incomeFreqIndicator) {
        this.incomeFreqIndicator = incomeFreqIndicator;
    }

    /**
     * to get errCodeEntryDate.
     *
     * @return errCodeEntryDate
     */
    public Date getErrCodeEntryDate() {
        return errCodeEntryDate;
    }

    /**
     * to set errCodeEntryDate.
     *
     * @param errCodeEntryDate
     */
    public void setErrCodeEntryDate(Date errCodeEntryDate) {
        this.errCodeEntryDate = errCodeEntryDate;
    }

    /**
     * to get errCode.
     *
     * @return errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * to set errCode.
     *
     * @param errCode
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * to get cibilRemarksCodeEntryDate.
     *
     * @return cibilRemarksCodeEntryDate
     */
    public Date getCibilRemarksCodeEntryDate() {
        return cibilRemarksCodeEntryDate;
    }

    /**
     * to set cibilRemarksCodeEntryDate.
     *
     * @param cibilRemarksCodeEntryDate
     */
    public void setCibilRemarksCodeEntryDate(Date cibilRemarksCodeEntryDate) {
        this.cibilRemarksCodeEntryDate = cibilRemarksCodeEntryDate;
    }

    /**
     * to get cibilRemarksCode.
     *
     * @return cibilRemarksCode
     */
    public String getCibilRemarksCode() {
        return cibilRemarksCode;
    }

    /**
     * to set cibilRemarksCode.
     *
     * @param cibilRemarksCode
     */
    public void setCibilRemarksCode(String cibilRemarksCode) {
        this.cibilRemarksCode = cibilRemarksCode;
    }

    /**
     * to get errRemarksCodeEntryDate.
     *
     * @return errRemarksCodeEntryDate
     */
    public Date getErrRemarksCodeEntryDate() {
        return errRemarksCodeEntryDate;
    }

    /**
     * to set errRemarksCodeEntryDate.
     *
     * @param errRemarksCodeEntryDate
     */
    public void setErrRemarksCodeEntryDate(Date errRemarksCodeEntryDate) {
        this.errRemarksCodeEntryDate = errRemarksCodeEntryDate;
    }

    /**
     * to get errRemarksCode1.
     *
     * @return errRemarksCode1
     */
    public String getErrRemarksCode1() {
        return errRemarksCode1;
    }

    /**
     * to set errRemarksCode1.
     *
     * @param errRemarksCode1
     */
    public void setErrRemarksCode1(String errRemarksCode1) {
        this.errRemarksCode1 = errRemarksCode1;
    }

    /**
     * to get errRemarksCode2.
     *
     * @return errRemarksCode2
     */
    public String getErrRemarksCode2() {
        return errRemarksCode2;
    }

    /**
     * to set errRemarksCode2.
     *
     * @param errRemarksCode2
     */
    public void setErrRemarksCode2(String errRemarksCode2) {
        this.errRemarksCode2 = errRemarksCode2;
    }

    /**
     * to get suppressionDate.
     *
     * @return suppressionDate
     */
    public Date getSuppressionDate() {
        return suppressionDate;
    }

    public String getEnrichMode() {
        return enrichMode;
    }

    public void setEnrichMode(String enrichMode) {
        this.enrichMode = enrichMode;
    }

    public String getEnrichMemberCode() {
        return enrichMemberCode;
    }

    public void setEnrichMemberCode(String enrichMemberCode) {
        this.enrichMemberCode = enrichMemberCode;
    }

    public Date getEnrichDate() {
        return enrichDate;
    }

    public void setEnrichDate(Date enrichDate) {
        this.enrichDate = enrichDate;
    }

    /**
     * to set suppressionDate.
     *
     * @param suppressionDate
     */
    public void setSuppressionDate(Date suppressionDate) {
        this.suppressionDate = suppressionDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmploymentDataFormatDate.class.getSimpleName() + "[", "]")
                .add("reportedDate=" + reportedDate)
                .add("occupationCode='" + occupationCode + "'")
                .add("income=" + income)
                .add("netGrossIncomeIndicator='" + netGrossIncomeIndicator + "'")
                .add("incomeFreqIndicator='" + incomeFreqIndicator + "'")
                .add("errCodeEntryDate=" + errCodeEntryDate)
                .add("errCode='" + errCode + "'")
                .add("cibilRemarksCodeEntryDate=" + cibilRemarksCodeEntryDate)
                .add("cibilRemarksCode='" + cibilRemarksCode + "'")
                .add("errRemarksCodeEntryDate=" + errRemarksCodeEntryDate)
                .add("errRemarksCode1='" + errRemarksCode1 + "'")
                .add("errRemarksCode2='" + errRemarksCode2 + "'")
                .add("enrichMode='" + enrichMode + "'")
                .add("enrichMemberCode='" + enrichMemberCode + "'")
                .add("enrichDate=" + enrichDate)
                .add("suppressionDate=" + suppressionDate)
                .toString();
    }
}

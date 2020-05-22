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
 * Bean class for email current.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class EmailCurrentFormatDate extends SubjectField {

    private long serialNumber;
    private String memberCode;
    private String emailID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date reportedDate;
    private String enrichMode;
    private String enrichMemberCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date enrichDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date suppressionDate;

    /**
     * to get serialNumber.
     *
     * @return serialNumber
     */
    public long getSerialNumber() {
        return serialNumber;
    }

    /**
     * to set serialNumber.
     *
     * @param serialNumber
     */
    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * to get memberCode.
     *
     * @return memberCode
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * to set memberCode.
     *
     * @param memberCode
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    /**
     * to get emailID.
     *
     * @return emailID
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * to set emailID.
     *
     * @param emailID
     */
    public void setEmailID(String emailID) {
        joinKey(emailID, "EC", getSerialNumber(), "01");
        this.emailID = emailID;
    }

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
     * to get suppressionDate.
     *
     * @return suppressionDate
     */
    public Date getSuppressionDate() {
        return suppressionDate;
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
        return new StringJoiner(", ", EmailCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("serialNumber=" + serialNumber)
                .add("memberCode='" + memberCode + "'")
                .add("emailID='" + emailID + "'")
                .add("reportedDate=" + reportedDate)
                .add("enrichMode='" + enrichMode + "'")
                .add("enrichMemberCode='" + enrichMemberCode + "'")
                .add("enrichDate=" + enrichDate)
                .add("suppressionDate=" + suppressionDate)
                .toString();
    }
}

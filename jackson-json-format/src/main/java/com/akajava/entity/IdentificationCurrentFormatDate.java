package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.logicbig.example.DateHandler;

import java.util.Date;
import java.util.StringJoiner;

/**
 * This is Bean Class for IdentificationCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class IdentificationCurrentFormatDate extends SubjectField {

    private long serialNumber;
    private String memberCode;
    private String idType;
    private String idNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date issueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date expiryDate;
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
     * to get idType.
     *
     * @return idType
     */
    public String getIdType() {
        return idType;
    }

    /**
     * to set idType.
     *
     * @param idType
     */
    public void setIdType(String idType) {
        joinKey(idType, "ID", getSerialNumber(), "01");
        this.idType = idType;
    }

    /**
     * to get idNumber.
     *
     * @return idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * to set idNumber.
     *
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        joinKey(idNumber, "ID", getSerialNumber(), "02");
        this.idNumber = idNumber;
    }

    /**
     * to get issueDate.
     *
     * @return issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * to set issueDate.
     *
     * @param issueDate
     */
    public void setIssueDate(Date issueDate) {
        joinKey(issueDate, "ID", getSerialNumber(), "03");
        this.issueDate = issueDate;
    }

    /**
     * to get expiryDate.
     *
     * @return expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * to set expiryDate.
     *
     * @param expiryDate
     */
    public void setExpiryDate(Date expiryDate) {
        joinKey(expiryDate, "ID", getSerialNumber(), "04");
        this.expiryDate = expiryDate;
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
        return new StringJoiner(", ", IdentificationCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("serialNumber=" + serialNumber)
                .add("memberCode='" + memberCode + "'")
                .add("idType='" + idType + "'")
                .add("idNumber='" + idNumber + "'")
                .add("issueDate=" + issueDate)
                .add("expiryDate=" + expiryDate)
                .add("reportedDate=" + reportedDate)
                .add("enrichMode='" + enrichMode + "'")
                .add("enrichMemberCode='" + enrichMemberCode + "'")
                .add("enrichDate=" + enrichDate)
                .add("suppressionDate=" + suppressionDate)
                .toString();
    }
}

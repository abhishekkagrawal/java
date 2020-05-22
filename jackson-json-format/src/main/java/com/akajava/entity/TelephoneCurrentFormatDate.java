package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.logicbig.example.DateHandler;

import java.util.Date;
import java.util.StringJoiner;

/**
 * This is Bean Class for TelephoneCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class TelephoneCurrentFormatDate extends SubjectField {

    private long serialNumber;
    private String memberCode;
    private String telephoneType;
    private String telephoneNumber;
    private String telephoneExtn;
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
     * to get telephoneType.
     *
     * @return
     */
    public String getTelephoneType() {
        return telephoneType;
    }

    /**
     * to set telephoneType.
     *
     * @param telephoneType
     */
    public void setTelephoneType(String telephoneType) {
        joinKey(telephoneType, "PT", getSerialNumber(), "03");
        this.telephoneType = telephoneType;
    }

    /**
     * to get telephoneNumber.
     *
     * @return telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * to set telephoneNumber.
     *
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        joinKey(telephoneNumber, "PT", getSerialNumber(), "01");
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * to get telephoneExtn.
     *
     * @return telephoneExtn
     */
    public String getTelephoneExtn() {
        return telephoneExtn;
    }

    /**
     * to set telephoneExtn.
     *
     * @param telephoneExtn
     */
    public void setTelephoneExtn(String telephoneExtn) {
        joinKey(telephoneExtn, "PT", getSerialNumber(), "02");
        this.telephoneExtn = telephoneExtn;
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

    /**
     * @return
     */
    public String getEnrichMode() {
        return enrichMode;
    }

    /**
     * @param enrichMode
     */
    public void setEnrichMode(String enrichMode) {
        this.enrichMode = enrichMode;
    }

    /**
     * @return
     */
    public String getEnrichMemberCode() {
        return enrichMemberCode;
    }

    /**
     * @param enrichMemberCode
     */
    public void setEnrichMemberCode(String enrichMemberCode) {
        this.enrichMemberCode = enrichMemberCode;
    }

    /**
     * @return
     */
    public Date getEnrichDate() {
        return enrichDate;
    }

    /**
     * @param enrichDate
     */
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
        return new StringJoiner(", ", TelephoneCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("serialNumber=" + serialNumber)
                .add("memberCode='" + memberCode + "'")
                .add("telephoneType='" + telephoneType + "'")
                .add("telephoneNumber='" + telephoneNumber + "'")
                .add("telephoneExtn='" + telephoneExtn + "'")
                .add("reportedDate=" + reportedDate)
                .add("enrichMode='" + enrichMode + "'")
                .add("enrichMemberCode='" + enrichMemberCode + "'")
                .add("enrichDate=" + enrichDate)
                .add("suppressionDate=" + suppressionDate)
                .toString();
    }
}

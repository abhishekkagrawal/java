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
 * Bean class for AddressCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class AddressCurrentFormatDate extends SubjectField {

    private long serialNumber;
    private String memberCode;
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String line5;
    private String stateCode;
    private String pinCode;
    private String addressCategory;
    private String residenceCode;
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
     * to get line1.
     *
     * @return line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * to set line1.
     *
     * @param line1
     */
    public void setLine1(String line1) {
        joinKey(line1, "PA", getSerialNumber(), "01");
        this.line1 = line1;
    }

    /**
     * to get line2.
     *
     * @return line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     * to set line2.
     *
     * @param line2
     */
    public void setLine2(String line2) {
        joinKey(line2, "PA", getSerialNumber(), "02");
        this.line2 = line2;
    }

    /**
     * to get line3.
     *
     * @return line3
     */
    public String getLine3() {
        return line3;
    }

    /**
     * to set line3.
     *
     * @param line3
     */
    public void setLine3(String line3) {
        joinKey(line3, "PA", getSerialNumber(), "03");
        this.line3 = line3;
    }

    /**
     * to get line4.
     *
     * @return line4
     */
    public String getLine4() {
        return line4;
    }

    /**
     * to set line4.
     *
     * @param line4
     */
    public void setLine4(String line4) {
        joinKey(line4, "PA", getSerialNumber(), "04");
        this.line4 = line4;
    }

    /**
     * to get line5.
     *
     * @return line5
     */
    public String getLine5() {
        return line5;
    }

    /**
     * to set line5.
     *
     * @param line5
     */
    public void setLine5(String line5) {
        joinKey(line5, "PA", getSerialNumber(), "05");
        this.line5 = line5;
    }

    /**
     * to get stateCode.
     *
     * @return stateCode
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * to set stateCode.
     *
     * @param stateCode
     */
    public void setStateCode(String stateCode) {
        joinKey(stateCode, "PA", getSerialNumber(), "06");
        this.stateCode = stateCode;
    }

    /**
     * to get pinCode.
     *
     * @return pinCode
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * to set pinCode.
     *
     * @param pinCode
     */
    public void setPinCode(String pinCode) {
        joinKey(pinCode, "PA", getSerialNumber(), "07");
        this.pinCode = pinCode;
    }

    /**
     * to get addressCategory.
     *
     * @return addressCategory
     */
    public String getAddressCategory() {
        return addressCategory;
    }

    /**
     * to set addressCategory.
     *
     * @param addressCategory
     */
    public void setAddressCategory(String addressCategory) {
        joinKey(addressCategory, "PA", getSerialNumber(), "08");
        this.addressCategory = addressCategory;
    }

    /**
     * to get residenceCode.
     *
     * @return residenceCode
     */
    public String getResidenceCode() {
        return residenceCode;
    }

    /**
     * to set residenceCode.
     *
     * @param residenceCode
     */
    public void setResidenceCode(String residenceCode) {
        joinKey(residenceCode, "PA", getSerialNumber(), "09");
        this.residenceCode = residenceCode;
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
        return new StringJoiner(", ", AddressCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("serialNumber=" + serialNumber)
                .add("memberCode='" + memberCode + "'")
                .add("line1='" + line1 + "'")
                .add("line2='" + line2 + "'")
                .add("line3='" + line3 + "'")
                .add("line4='" + line4 + "'")
                .add("line5='" + line5 + "'")
                .add("stateCode='" + stateCode + "'")
                .add("pinCode='" + pinCode + "'")
                .add("addressCategory='" + addressCategory + "'")
                .add("residenceCode='" + residenceCode + "'")
                .add("reportedDate=" + reportedDate)
                .add("enrichMode='" + enrichMode + "'")
                .add("enrichMemberCode='" + enrichMemberCode + "'")
                .add("enrichDate=" + enrichDate)
                .add("suppressionDate=" + suppressionDate)
                .toString();
    }
}

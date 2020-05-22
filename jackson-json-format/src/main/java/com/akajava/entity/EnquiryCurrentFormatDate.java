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
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.StringJoiner;

/**
 * Bean class for EnquiryCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class EnquiryCurrentFormatDate extends SubjectField {

    private long ecn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date dateOfEnquiry;
    private String enqPurpose;
    private long enqAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date suppressionDate;
    private String memberCode;

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
     * to get ecn.
     *
     * @return ecn
     */
    public long getEcn() {
        return ecn;
    }

    /**
     * to set ecn.
     *
     * @param ecn
     */
    public void setEcn(long ecn) {
        this.ecn = ecn;
    }

    /**
     * to get dateOfEnquiry.
     *
     * @return dateOfEnquiry
     */
    private Date getDateOfEnquiry() {
        return dateOfEnquiry;
    }

    /**
     * to set dateOfEnquiry.
     *
     * @param dateOfEnquiry
     */
    public void setDateOfEnquiry(Date dateOfEnquiry) {
        this.dateOfEnquiry = dateOfEnquiry;
    }

    /**
     * to get enqPurpose.
     *
     * @return enqPurpose
     */
    public String getEnqPurpose() {
        return enqPurpose;
    }

    /**
     * to set enqPurpose.
     *
     * @param enqPurpose
     */
    public void setEnqPurpose(String enqPurpose) {
        joinKey(enqPurpose, "IQ", StringUtils.substring(getMemberCode(), 0, 6), getDateOfEnquiry(), getEcn(), "05");
        this.enqPurpose = enqPurpose;
    }

    /**
     * to get enqAmount.
     *
     * @return enqAmount
     */
    public long getEnqAmount() {
        return enqAmount;
    }

    /**
     * to set enqAmount.
     *
     * @param enqAmount
     */
    public void setEnqAmount(long enqAmount) {
        joinKey(enqAmount, "IQ", StringUtils.substring(getMemberCode(), 0, 6), getDateOfEnquiry(), getEcn(), "06");
        this.enqAmount = enqAmount;
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
        return new StringJoiner(", ", EnquiryCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("ecn=" + ecn)
                .add("dateOfEnquiry=" + dateOfEnquiry)
                .add("enqPurpose='" + enqPurpose + "'")
                .add("enqAmount=" + enqAmount)
                .add("suppressionDate=" + suppressionDate)
                .add("memberCode='" + memberCode + "'")
                .toString();
    }
}

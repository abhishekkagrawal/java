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
 * Bean class for DisputeCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class DisputeCurrentFormatDate {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date updatedDate;
    private long serialNumber;
    private String memberCode;
    private String dispRemarks1;
    private String dispRemarks2;
    private String dispRemarks3;
    private String dispRemarks4;
    private String dispRemarks5;
    private String dispRemarks6;

    /**
     * to get updatedDate.
     *
     * @return updatedDate
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * to set updatedDate.
     *
     * @param updatedDate
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

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
     * to get dispRemarks1.
     *
     * @return dispRemarks1
     */
    public String getDispRemarks1() {
        return dispRemarks1;
    }

    /**
     * to set dispRemarks1.
     *
     * @param dispRemarks1
     */
    public void setDispRemarks1(String dispRemarks1) {
        this.dispRemarks1 = dispRemarks1;
    }

    /**
     * to get dispRemarks2.
     *
     * @return dispRemarks2
     */
    public String getDispRemarks2() {
        return dispRemarks2;
    }

    /**
     * to set dispRemarks2.
     *
     * @param dispRemarks2
     */
    public void setDispRemarks2(String dispRemarks2) {
        this.dispRemarks2 = dispRemarks2;
    }

    /**
     * to get dispRemarks3.
     *
     * @return dispRemarks3
     */
    public String getDispRemarks3() {
        return dispRemarks3;
    }

    /**
     * to set dispRemarks3.
     *
     * @param dispRemarks3
     */
    public void setDispRemarks3(String dispRemarks3) {
        this.dispRemarks3 = dispRemarks3;
    }

    /**
     * to get dispRemarks4.
     *
     * @return dispRemarks4
     */
    public String getDispRemarks4() {
        return dispRemarks4;
    }

    /**
     * to set dispRemarks4.
     *
     * @param dispRemarks4
     */
    public void setDispRemarks4(String dispRemarks4) {
        this.dispRemarks4 = dispRemarks4;
    }

    /**
     * to get dispRemarks5.
     *
     * @return dispRemarks5
     */
    public String getDispRemarks5() {
        return dispRemarks5;
    }

    /**
     * to set dispRemarks5.
     *
     * @param dispRemarks5
     */
    public void setDispRemarks5(String dispRemarks5) {
        this.dispRemarks5 = dispRemarks5;
    }

    /**
     * to get dispRemarks6.
     *
     * @return dispRemarks6
     */
    public String getDispRemarks6() {
        return dispRemarks6;
    }

    /**
     * to set dispRemarks6.
     *
     * @param dispRemarks6
     */
    public void setDispRemarks6(String dispRemarks6) {
        this.dispRemarks6 = dispRemarks6;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DisputeCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("updatedDate=" + updatedDate)
                .add("serialNumber=" + serialNumber)
                .add("memberCode='" + memberCode + "'")
                .add("dispRemarks1='" + dispRemarks1 + "'")
                .add("dispRemarks2='" + dispRemarks2 + "'")
                .add("dispRemarks3='" + dispRemarks3 + "'")
                .add("dispRemarks4='" + dispRemarks4 + "'")
                .add("dispRemarks5='" + dispRemarks5 + "'")
                .add("dispRemarks6='" + dispRemarks6 + "'")
                .toString();
    }
}

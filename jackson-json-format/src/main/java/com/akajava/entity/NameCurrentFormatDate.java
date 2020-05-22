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
 * Bean class for NameCurrent.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "current")
public class NameCurrentFormatDate extends SubjectField {

    private String memberCode;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date dob;
    private String gender;
    private String enrichModeName;
    private String enrichMemberCodeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date enrichDateName;
    private String enrichModeDob;
    private String enrichMemberCodeDob;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date enrichDateDob;
    private String enrichModeGender;
    private String enrichMemberCodeGender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date enrichDateGender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    @JsonSerialize(using = DateHandler.class)
    private Date errCodeEntryDate;
    private String errSegmentTag;
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
    private String suppressionDate;
    private String dontDisplay;

    /**
     * to get memberCode.
     *
     * @return memberCode
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * to set name1.
     *
     * @param memberCode
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    /**
     * to get name1.
     *
     * @return name1
     */
    public String getName1() {
        return name1;
    }

    /**
     * to set name1.
     *
     * @param name1
     */
    public void setName1(String name1) {
        joinKey(name1, "PN", "01");
        this.name1 = name1;
    }

    /**
     * to get name2.
     *
     * @return name2
     */
    public String getName2() {
        return name2;
    }

    /**
     * to get name2.
     *
     * @param name2
     */
    public void setName2(String name2) {
        joinKey(name2, "PN", "02");
        this.name2 = name2;
    }

    /**
     * to get name3.
     *
     * @return name3
     */
    public String getName3() {
        return name3;
    }

    /**
     * to set name3.
     *
     * @param name3
     */
    public void setName3(String name3) {
        joinKey(name3, "PN", "03");
        this.name3 = name3;
    }

    /**
     * to get name4.
     *
     * @return name4
     */
    public String getName4() {
        return name4;
    }

    /**
     * to set name4.
     *
     * @param name4
     */
    public void setName4(String name4) {
        joinKey(name4, "PN", "04");
        this.name4 = name4;
    }

    /**
     * to get name5.
     *
     * @return name5
     */
    public String getName5() {
        return name5;
    }

    /**
     * to set name5.
     *
     * @param name5
     */
    public void setName5(String name5) {
        joinKey(name5, "PN", "05");
        this.name5 = name5;
    }

    /**
     * to get dob.
     *
     * @return dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * to set dob.
     *
     * @param dob
     */
    public void setDob(Date dob) {
        joinKey(dob, "PN", "07");
        this.dob = dob;
    }

    /**
     * to get gender.
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * to set gender.
     *
     * @param gender
     */
    public void setGender(String gender) {
        joinKey(gender, "PN", "08");
        this.gender = gender;
    }

    public String getEnrichModeName() {
        return enrichModeName;
    }

    public void setEnrichModeName(String enrichModeName) {
        this.enrichModeName = enrichModeName;
    }

    public String getEnrichMemberCodeName() {
        return enrichMemberCodeName;
    }

    public void setEnrichMemberCodeName(String enrichMemberCodeName) {
        this.enrichMemberCodeName = enrichMemberCodeName;
    }

    public Date getEnrichDateName() {
        return enrichDateName;
    }

    public void setEnrichDateName(Date enrichDateName) {
        this.enrichDateName = enrichDateName;
    }

    public String getEnrichModeDob() {
        return enrichModeDob;
    }

    public void setEnrichModeDob(String enrichModeDob) {
        this.enrichModeDob = enrichModeDob;
    }

    public String getEnrichMemberCodeDob() {
        return enrichMemberCodeDob;
    }

    public void setEnrichMemberCodeDob(String enrichMemberCodeDob) {
        this.enrichMemberCodeDob = enrichMemberCodeDob;
    }

    public Date getEnrichDateDob() {
        return enrichDateDob;
    }

    public void setEnrichDateDob(Date enrichDateDob) {
        this.enrichDateDob = enrichDateDob;
    }

    public String getEnrichModeGender() {
        return enrichModeGender;
    }

    public void setEnrichModeGender(String enrichModeGender) {
        this.enrichModeGender = enrichModeGender;
    }

    public String getEnrichMemberCodeGender() {
        return enrichMemberCodeGender;
    }

    public void setEnrichMemberCodeGender(String enrichMemberCodeGender) {
        this.enrichMemberCodeGender = enrichMemberCodeGender;
    }

    public Date getEnrichDateGender() {
        return enrichDateGender;
    }

    public void setEnrichDateGender(Date enrichDateGender) {
        this.enrichDateGender = enrichDateGender;
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
     * to get errSegmentTag.
     *
     * @return errSegmentTag
     */
    public String getErrSegmentTag() {
        return errSegmentTag;
    }

    /**
     * to set errSegmentTag.
     *
     * @param errSegmentTag
     */
    public void setErrSegmentTag(String errSegmentTag) {
        this.errSegmentTag = errSegmentTag;
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
    public String getSuppressionDate() {
        return suppressionDate;
    }

    /**
     * to set suppressionDate.
     *
     * @param suppressionDate
     */
    public void setSuppressionDate(String suppressionDate) {
        this.suppressionDate = suppressionDate;
    }

    /**
     * to get dontDisplay.
     *
     * @return dontDisplay
     */
    public String getDontDisplay() {
        return dontDisplay;
    }

    /**
     * to set dontDisplay.
     *
     * @param dontDisplay
     */
    public void setDontDisplay(String dontDisplay) {
        this.dontDisplay = dontDisplay;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NameCurrentFormatDate.class.getSimpleName() + "[", "]")
                .add("memberCode='" + memberCode + "'")
                .add("name1='" + name1 + "'")
                .add("name2='" + name2 + "'")
                .add("name3='" + name3 + "'")
                .add("name4='" + name4 + "'")
                .add("name5='" + name5 + "'")
                .add("dob=" + dob)
                .add("gender='" + gender + "'")
                .add("enrichModeName='" + enrichModeName + "'")
                .add("enrichMemberCodeName='" + enrichMemberCodeName + "'")
                .add("enrichDateName=" + enrichDateName)
                .add("enrichModeDob='" + enrichModeDob + "'")
                .add("enrichMemberCodeDob='" + enrichMemberCodeDob + "'")
                .add("enrichDateDob=" + enrichDateDob)
                .add("enrichModeGender='" + enrichModeGender + "'")
                .add("enrichMemberCodeGender='" + enrichMemberCodeGender + "'")
                .add("enrichDateGender=" + enrichDateGender)
                .add("errCodeEntryDate=" + errCodeEntryDate)
                .add("errSegmentTag='" + errSegmentTag + "'")
                .add("errCode='" + errCode + "'")
                .add("cibilRemarksCodeEntryDate=" + cibilRemarksCodeEntryDate)
                .add("cibilRemarksCode='" + cibilRemarksCode + "'")
                .add("errRemarksCodeEntryDate=" + errRemarksCodeEntryDate)
                .add("errRemarksCode1='" + errRemarksCode1 + "'")
                .add("errRemarksCode2='" + errRemarksCode2 + "'")
                .add("suppressionDate='" + suppressionDate + "'")
                .add("dontDisplay='" + dontDisplay + "'")
                .toString();
    }
}

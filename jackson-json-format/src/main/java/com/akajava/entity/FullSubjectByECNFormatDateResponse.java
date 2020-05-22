/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.StringJoiner;

/**
 * to map Response. for interface 006
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "ICRS_FullSubjectByECN_Response")
public class FullSubjectByECNFormatDateResponse {

    private boolean success;
    private String turfString;
    @JsonProperty("subject")
    private SubjectFieldsFormatDate subject;

    @Override
    public String toString() {
        return new StringJoiner(", ", FullSubjectByECNFormatDateResponse.class.getSimpleName() + "[", "]")
                .add("success=" + success)
                .add("turfString='" + turfString + "'")
                .add("subject=" + subject)
                .toString();
    }

    /**
     * to get value of success.
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * to set value of success.
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * to get turfString.
     *
     * @return String
     */
    public String getTurfString() {
        return turfString;
    }

    /**
     * to get turfString.
     *
     * @param turfString
     */
    public void setTurfString(String turfString) {
        this.turfString = turfString;
    }

    /**
     * to get subject.
     *
     * @return SubjectFields
     */
    public SubjectFieldsFormatDate getSubject() {
        return subject;
    }

    /**
     * to set subject.
     *
     * @param subject
     */
    public void setSubject(SubjectFieldsFormatDate subject) {
        this.subject = subject;
    }

}

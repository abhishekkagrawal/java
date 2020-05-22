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
 * This is Bean Class for DisputeData.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "consDisputeRemarksData")
public class DisputeDataFormatDate {

    @JsonProperty("current")
    private DisputeCurrentFormatDate disputeCurrent;

    /**
     * @return the disputeCurrent
     */
    public DisputeCurrentFormatDate getDisputeCurrent() {
        return disputeCurrent;
    }

    /**
     * @param disputeCurrent the disputeCurrent to set
     */
    public void setDisputeCurrent(DisputeCurrentFormatDate disputeCurrent) {
        this.disputeCurrent = disputeCurrent;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DisputeDataFormatDate.class.getSimpleName() + "[", "]")
                .add("disputeCurrent=" + disputeCurrent)
                .toString();
    }
}

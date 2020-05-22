/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * Bean class for EnquiryFields.
 *
 * @author Pratik Varpe
 */
public class EnquiryFieldsFormatDate {

    @JsonProperty("current")
    private EnquiryCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public EnquiryCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(EnquiryCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EnquiryFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

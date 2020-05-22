/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * Bean class for TelephoneFields.
 *
 * @author Pratik Varpe
 */
public class TelephoneFieldsFormatDate {

    @JsonProperty("current")
    private TelephoneCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public TelephoneCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(TelephoneCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TelephoneFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

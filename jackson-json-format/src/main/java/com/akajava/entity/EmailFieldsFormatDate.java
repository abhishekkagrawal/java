/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * Bean class for EmailFields.
 *
 * @author Pratik Varpe
 */
public class EmailFieldsFormatDate {

    @JsonProperty("current")
    private EmailCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public EmailCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(EmailCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmailFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

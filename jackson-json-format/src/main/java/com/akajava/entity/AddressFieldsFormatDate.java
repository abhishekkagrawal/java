/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * Bean class for AddressFields.
 *
 * @author Pratik Varpe
 */
public class AddressFieldsFormatDate {

    @JsonProperty("current")
    private AddressCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return current
     */
    public AddressCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * to set current.
     *
     * @param current
     */
    public void setCurrent(AddressCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

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
 * Bean class for NameFields.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "nameData")
public class NameFieldsFormatDate {

    @JsonProperty("current")
    private NameCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public NameCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(NameCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NameFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

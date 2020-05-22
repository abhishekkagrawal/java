package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.StringJoiner;

/**
 * Bean class for IdentificationFields.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "idDataArray")
public class IdentificationFieldsFormatDate {

    @JsonProperty("current")
    private IdentificationCurrentFormatDate current;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public IdentificationCurrentFormatDate getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(IdentificationCurrentFormatDate current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IdentificationFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("current=" + current)
                .toString();
    }
}

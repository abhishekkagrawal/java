package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Bean class for SubjectLevelData.
 *
 * @author Pratik Varpe
 */
@JsonRootName(value = "subjectLevelData")
public class SubjectLevelData {

    private SubjectCurrent current;
    private Control control;

    /**
     * to get current.
     *
     * @return CurrentFields
     */
    public SubjectCurrent getCurrent() {
        return current;
    }

    /**
     * @param current
     */
    public void setCurrent(SubjectCurrent current) {
        this.current = current;
    }

    /**
     * to get control.
     *
     * @return Control
     */
    public Control getControl() {
        return control;
    }

    /**
     * to set control.
     *
     * @param control
     */
    public void setControl(Control control) {
        this.control = control;
    }
}

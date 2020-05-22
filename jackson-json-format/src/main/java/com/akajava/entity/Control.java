/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

/**
 * Bean class for Control.
 *
 * @author Pratik Varpe
 */
public class Control {

    private boolean status;
    private boolean fidChanged;

    /**
     * to check status.
     *
     * @return boolean
     */
    public boolean isStatus() {
        return this.status;
    }

    /**
     * to set status.
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * to check fidChanged.
     *
     * @return boolean
     */
    public boolean isFidChanged() {
        return this.fidChanged;
    }

    /**
     * to set fidChanged.
     *
     * @param fidChanged
     */
    public void setFidChanged(boolean fidChanged) {
        this.fidChanged = fidChanged;
    }
}

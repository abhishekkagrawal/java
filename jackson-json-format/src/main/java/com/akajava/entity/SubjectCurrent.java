/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

/**
 * This is Bean Class for SubjectCurrent.
 *
 * @author Pratik Varpe
 */
public class SubjectCurrent {

    private long fid;
    private long generationNumber;

    /**
     * to get generationNumber.
     *
     * @return generationNumber
     */
    public long getGenerationNumber() {
        return this.generationNumber;
    }

    /**
     * to set generationNumber.
     *
     * @param generationNumber
     */
    public void setGenerationNumber(long generationNumber) {
        this.generationNumber = generationNumber;
    }

    /**
     * to get fid.
     *
     * @return fid
     */
    public long getFid() {
        return this.fid;
    }

    /**
     * to set fid.
     *
     * @param fid
     */
    public void setFid(long fid) {
        this.fid = fid;
    }

}

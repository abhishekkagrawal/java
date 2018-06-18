package com.capgemini.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Owner
 */
@XmlRootElement(name = "faml")
@XmlAccessorType(XmlAccessType.NONE)
@JacksonXmlRootElement(localName = "faml")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerificationResponse {

    private String memberRefId;

    private String referenceNo;

    private String transactionId;

    private String transactionDate;

    private String extSessionId;

    private String checksum;

    private String checkSum;

    private String extSystemId;
    @XmlElement(name = "rc")
    private ErrorResponse errResponse;

    // <editor-fold desc="Getters & setters" defaultstate="collapsed">
    /**
     * @return the memberRefId
     */
    @XmlElement(name = "MEMBERREFID")
    @JacksonXmlProperty(localName = "MEMBERREFID")
    public String getMemberRefId() {
	return memberRefId;
    }

    /**
     * @param memberRefId
     *            the memberRefId to set
     */
    public void setMemberRefId(String memberRefId) {
	this.memberRefId = memberRefId;
    }

    /**
     * @return the referenceNo
     */
    @XmlElement(name = "REFERENCENO")
    @JacksonXmlProperty(localName = "REFERENCENO")
    public String getReferenceNo() {
	return referenceNo;
    }

    /**
     * @param referenceNo
     *            the referenceNo to set
     */
    public void setReferenceNo(String referenceNo) {
	this.referenceNo = referenceNo;
    }

    /**
     * @return the transactionId
     */
    @JacksonXmlProperty(localName = "TRANSACTIONID")
    public String getTransactionId() {
	return transactionId;
    }

    /**
     * @param transactionId
     *            the transactionId to set
     */
    public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
    }

    /**
     * @return the transactionDate
     */
    @XmlElement(name = "TRANSACTIONDATE")
    @JacksonXmlProperty(localName = "TRANSACTIONDATE")
    public String getTransactionDate() {
	return transactionDate;
    }

    /**
     * @param transactionDate
     *            the transactionDate to set
     */
    public void setTransactionDate(String transactionDate) {
	this.transactionDate = transactionDate;
    }

    @XmlElement(name = "EXTSESSIONID")
    @JacksonXmlProperty(localName = "EXTSESSIONID")
    public String getExtSessionId() {
	return extSessionId;
    }

    public void setExtSessionId(String extSessionId) {
	this.extSessionId = extSessionId;
    }

    /**
     * @return the checksum
     */
    @XmlElement(name = "CHECKSUM")
    @JacksonXmlProperty(localName = "CHECKSUM")
    public String getChecksum() {
	return checksum;
    }

    /**
     * @param checksum
     *            the checksum to set
     */
    public void setChecksum(String checksum) {
	this.checksum = checksum;
    }

    /**
     * @return the extSystemId
     */
    @XmlElement(name = "EXTSYSTEMID")
    @JacksonXmlProperty(localName = "EXTSYSTEMID")
    public String getExtSystemId() {
	return extSystemId;
    }

    /**
     * @param extSysytemId
     *            the extSystemId to set
     */
    public void setExtSystemId(String extSysytemId) {
	this.extSystemId = extSysytemId;
    }

    @JacksonXmlProperty(localName = "rc")
    public ErrorResponse getErrResponse() {
	return errResponse;
    }

    public void setErrResponse(ErrorResponse errResponse) {
	this.errResponse = errResponse;
    }

    @XmlElement(name = "checksum")
    @JacksonXmlProperty(localName = "checksum")
    public String getCheckSum() {
	return checkSum;
    }

    public void setCheckSum(String checkSum) {
	this.checkSum = checkSum;
    }

    @Override
    public String toString() {
	return "VerificationResponse [memberRefId=" + memberRefId + ", referenceNo=" + referenceNo + ", transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", extSessionId=" + extSessionId + ", checksum=" + checksum
		+ ", checkSum=" + checkSum + ", extSystemId=" + extSystemId + ", errResponse=" + errResponse + "]";
    }

}

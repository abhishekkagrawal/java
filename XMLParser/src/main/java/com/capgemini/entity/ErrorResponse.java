package com.capgemini.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.enums.VerificationErrorCodes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Owner
 */
@XmlRootElement(name = "rc")

@JsonIgnoreProperties(value = { "errorCode" })
public class ErrorResponse {

    private VerificationErrorCodes errorCode;

    private String errormessage;

    private int returncode;

    public ErrorResponse() {

	this.errormessage = "";

    }

    // <editor-fold desc="Getters & setters" defaultstate="collapsed">
    public VerificationErrorCodes getErrorCode() {
	return errorCode;
    }

    public void setErrorCode(VerificationErrorCodes errorCode) {

	this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    @XmlAttribute(name = "errormessage")
    @JacksonXmlProperty(isAttribute = true)
    public String getErrormessage() {
	return errormessage;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrormessage(String errorMessage) {
	this.errormessage = errorMessage;
    }

    @XmlAttribute(name = "returncode")
    @JacksonXmlProperty(isAttribute = true)
    public int getReturncode() {
	return returncode;
    }

    public void setReturncode(int returncode) {
	this.returncode = returncode;
    }

    // </editor-fold>
    @XmlAttribute(name = "errorcode")
    @JacksonXmlProperty(localName = "errorcode", isAttribute = true)
    public void setErrorCodeEnum(String errorCode) {
	if (!errorCode.equals("")) {
	    this.errorCode = VerificationErrorCodes.getVerificationErrorCode(errorCode);
	} else {
	    this.errorCode = null;
	}
    }

    @XmlAttribute(name = "errorcode")
    @JacksonXmlProperty(isAttribute = true)
    public String getErrorcode() {
	return errorCode != null ? errorCode.getCode() : "";
    }

    @Override
    public String toString() {
	return "ErrorResponse [errorCode=" + errorCode + ", errormessage=" + errormessage + ", returncode=" + returncode + "]";
    }
}

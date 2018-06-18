package com.capgemini.enums;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Owner
 */
public enum VerificationErrorCodes {

    RETAIL_BAD_INPUT_REQUEST("10015", "RETAIL_BAD_INPUT_REQUEST"),
    MID_USER_SESSION_TIME_OUT("16012", "MID_USER_SESSION_TIME_OUT"),
    MID_CHECK_SUM_CALC_ERR("22095", "MID_CHECK_SUM_CALC_ERR"),
    E_IB_DUP_TXN("1049", "E_IB_DUP_TXN"),
    E_RJS_NO_DATA("1185", "E_RJS_NO_DATA"),
    MID_JAVA_EXCEPTION("10001", "MID_JAVA_EXCEPTION");

    private String code;
    private String text;

    private VerificationErrorCodes(String code, String text) {
	this.code = code;
	this.text = text;

    }

    private VerificationErrorCodes(String code) {
	this.code = code;

    }

    /**
     * @return the code
     */
    public String getCode() {
	return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
	this.code = code;
    }

    /**
     * @return the text
     */
    public String getText() {
	return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
	this.text = text;
    }

    public static VerificationErrorCodes getVerificationErrorCode(final String id) {
	VerificationErrorCodes error = null;
	final List<VerificationErrorCodes> values = Arrays.asList(VerificationErrorCodes.values());
	final ListIterator<VerificationErrorCodes> iter = values.listIterator();
	while (iter.hasNext()) {
	    error = iter.next();
	    if (error.getCode().equals(id)) {
		break;
	    } else {
		error = null;
	    }
	}
	return error;
    }

}

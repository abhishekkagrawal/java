package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Owner
 */
public class SubjectField {

    @JsonIgnore
    private Map<String, Object> fieldValues = new LinkedHashMap<>();
    @JsonIgnore
    private static final String TUEFDATEFORMAT = "yyyyMMdd";
    @JsonIgnore
    private static final String KEYSEPARATOR = "-";


    /**
     * @return the fieldValues
     */
    @JsonIgnore
    Map<String, Object> getFieldValues() {
        return fieldValues;
    }

    public void joinKey(Object value, Object... key) {
        final String newKey = StringUtils.join(key, KEYSEPARATOR);
        getFieldValues().put(newKey, value);
    }

    void addPaymentHistoryDataInFieldMap(String startDate, String endDate, long[] paymentHistory, String memberCode, String accountNumber) {
        try {
            if (paymentHistory.length != 0) {
                final ListIterator<Long> paymentHistoryList = Arrays.asList(ArrayUtils.toObject(paymentHistory)).listIterator();
                int i;
                Date nextDate = new Date();
                while (paymentHistoryList.hasNext()) {
                    i = paymentHistoryList.nextIndex();
                    final long value = paymentHistoryList.next();
                    nextDate = getNextPaymentDate(i > 0 ? nextDate : null, startDate);
                    final Calendar cal = Calendar.getInstance();
                    cal.setTime(nextDate);
                    // adding 1 in month as in cal class jan ==0
                    final int month = cal.get(Calendar.MONTH) + 1;
                    final String monthYearValue = String.valueOf(month).length() == 1 ? "0" + String.valueOf(month) : String.valueOf(month);
//                    joinKey(value, TuefUtil.getResourceProperty(Constants.ACCOUNT_SEGMENT_TAG), memberCode, accountNumber, monthYearValue.concat(String.valueOf(cal.get(Calendar.YEAR))), TuefUtil.getResourceProperty(Constants.PAYMENTHISTORY1_TAG));
                }
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    void addPaymentHistoryDataInFieldMap(Date startDate, Date endDate, long[] paymentHistory, String memberCode, String accountNumber) {
        try {
            SimpleDateFormat sdfTo = new SimpleDateFormat("yyyyMMdd");
            String stDate = sdfTo.format(startDate);
            String edDate = sdfTo.format(endDate);

            addPaymentHistoryDataInFieldMap(stDate, edDate, paymentHistory, memberCode, accountNumber);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private Date getNextPaymentDate(Date startDate, String paymentHistoryStartDate) {
        Date nextDate = null;
        try {
            final SimpleDateFormat formatter = new SimpleDateFormat(TUEFDATEFORMAT);
            if (startDate != null) {
                final Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.add(Calendar.MONTH, -1);
                nextDate = cal.getTime();
            } else {
                nextDate = formatter.parse(paymentHistoryStartDate);
            }
        } catch (final ParseException ex) {
            ex.printStackTrace();
        }
        return nextDate;

    }
}

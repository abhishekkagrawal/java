/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajava.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Bean class for SubjectFields.
 *
 * @author Pratik Varpe
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName(value = "subject")
public class SubjectFieldsFormatDate {

    @JsonProperty("subjectLevelData")
    private SubjectLevelData subjectLevelData;
    @JsonProperty("nameData")
    private NameFieldsFormatDate nameData;
    @JsonProperty("idDataArray")
    private transient IdentificationFieldsFormatDate[] idData;
    @JsonProperty("telephoneDataArray")
    private transient TelephoneFieldsFormatDate[] telephoneData;
    @JsonProperty("addressDataArray")
    private transient AddressFieldsFormatDate[] addressData;
    @JsonProperty("emailDataArray")
    private transient EmailFieldsFormatDate[] emailData;
    //    @JsonProperty("accountDataArray")
//    private transient AccountsFieldsFormatDate[] accountData;
    @JsonProperty("enquiryDataArray")
    private transient EnquiryFieldsFormatDate[] enquiryData;
    private EmploymentDataFormatDate EmploymentDataFormatDate;
    @JsonProperty("consDisputeRemarksData")
    private DisputeDataFormatDate disputeData;

    private Map<String, Object> fieldValue = new LinkedHashMap<>();

    /**
     * to get subjectLevelData.
     *
     * @return SubjectLevelData
     */
    public SubjectLevelData getSubjectLevelData() {
        return subjectLevelData;
    }

    /**
     * to get idDataArray.
     *
     * @return IdentificationFields[]
     */
    public IdentificationFieldsFormatDate[] getIdDataArray() {
        return idData;
    }

    /**
     * to set idDataArray.
     *
     * @param idDataArray
     */
    public void setIdDataArray(IdentificationFieldsFormatDate[] idDataArray) {
        ListIterator<IdentificationFieldsFormatDate> iterator = Arrays.asList(idDataArray).listIterator();
        while (iterator.hasNext()) {
            IdentificationFieldsFormatDate fields = iterator.next();
            addAllFieldValues(fields.getCurrent().getFieldValues());
        }
        idData = idDataArray;
    }

    /**
     * to get telephoneDataArray.
     *
     * @return TelephoneFields[]
     */
    public TelephoneFieldsFormatDate[] getTelephoneDataArray() {
        return telephoneData;
    }

    /**
     * to set telephoneDataArray.
     *
     * @param telephoneDataArray
     */
    public void setTelephoneDataArray(TelephoneFieldsFormatDate[] telephoneDataArray) {
        ListIterator<TelephoneFieldsFormatDate> iterator = Arrays.asList(telephoneDataArray).listIterator();
        while (iterator.hasNext()) {
            TelephoneFieldsFormatDate fields = iterator.next();
            addAllFieldValues(fields.getCurrent().getFieldValues());
        }
        telephoneData = telephoneDataArray;
    }

    /**
     * to get addressDataArray.
     *
     * @return AddressFieldsFormatDate[]
     */
    public AddressFieldsFormatDate[] getAddressDataArray() {
        return addressData;
    }

    /**
     * to set addressDataArray.
     *
     * @param addressDataArray
     */
    public void setAddressDataArray(AddressFieldsFormatDate[] addressDataArray) {
        ListIterator<AddressFieldsFormatDate> iterator = Arrays.asList(addressDataArray).listIterator();
        while (iterator.hasNext()) {
            AddressFieldsFormatDate fields = iterator.next();
            addAllFieldValues(fields.getCurrent().getFieldValues());
        }
        addressData = addressDataArray;
    }

    /**
     * to get emailDataArray.
     *
     * @return EmailFieldsFormatDate[]
     */
    public EmailFieldsFormatDate[] getEmailDataArray() {
        return emailData;
    }

    /**
     * to set emailDataArray.
     *
     * @param emailDataArray
     */
    public void setEmailDataArray(EmailFieldsFormatDate[] emailDataArray) {
        ListIterator<EmailFieldsFormatDate> iterator = Arrays.asList(emailDataArray).listIterator();
        while (iterator.hasNext()) {
            EmailFieldsFormatDate fields = iterator.next();
            addAllFieldValues(fields.getCurrent().getFieldValues());
        }
        emailData = emailDataArray;
    }

    /**
     * to get accountDataArray.
     *
     * @return AccountsFieldsFormatDate
     */
//    public AccountsFieldsFormatDate[] getAccountDataArray() {
//        return accountData;
//    }
//
//    /**
//     * to set accountDataArray.
//     *
//     * @param accountDataArray
//     */
//    public void setAccountDataArray(AccountsFieldsFormatDate[] accountDataArray) {
//        ListIterator<AccountsFieldsFormatDate> iterator = Arrays.asList(accountDataArray).listIterator();
//        while (iterator.hasNext()) {
//            AccountsFieldsFormatDate fields = iterator.next();
//            addAllFieldValues(fields.getCurrent().getFieldValues());
//        }
//        accountData = accountDataArray;
//    }

    /**
     * to get enquiryDataArray.
     *
     * @return EnquiryFieldsFormatDate[]
     */
    public EnquiryFieldsFormatDate[] getEnquiryDataArray() {
        return enquiryData;
    }

    /**
     * to set enquiryDataArray.
     *
     * @param enquiryDataArray
     */
    public void setEnquiryDataArray(EnquiryFieldsFormatDate[] enquiryDataArray) {
        ListIterator<EnquiryFieldsFormatDate> iterator = Arrays.asList(enquiryDataArray).listIterator();
        while (iterator.hasNext()) {
            EnquiryFieldsFormatDate fields = iterator.next();
            addAllFieldValues(fields.getCurrent().getFieldValues());
        }
        enquiryData = enquiryDataArray;
    }

    /**
     * to get nameData.
     *
     * @return NameFieldsFormatDate[]
     */
    public NameFieldsFormatDate getNameData() {
        return nameData;
    }

    /**
     * to set nameData.
     *
     * @param nameData
     */
    public void setNameData(NameFieldsFormatDate nameData) {
        addAllFieldValues(nameData.getCurrent().getFieldValues());
        this.nameData = nameData;
    }

    /**
     * to set subjectLevelData.
     *
     * @param subjectLevelData
     */
    public void setSubjectLevelData(SubjectLevelData subjectLevelData) {
        this.subjectLevelData = subjectLevelData;
    }

    /**
     * to get suitFiledStatus.
     *
     * @return suitFiledStatus
     */
    public EmploymentDataFormatDate getEmploymentData() {
        return EmploymentDataFormatDate;
    }

    /**
     * to set EmploymentDataFormatDate.
     *
     * @param EmploymentDataFormatDate
     */
    public void setEmploymentData(EmploymentDataFormatDate EmploymentDataFormatDate) {
        addAllFieldValues(EmploymentDataFormatDate.getFieldValues());
        this.EmploymentDataFormatDate = EmploymentDataFormatDate;
    }

    /**
     * to get disputeData.
     *
     * @return disputeData
     */
    public DisputeDataFormatDate getDisputeData() {
        return disputeData;
    }

    /**
     * to set disputeData.
     *
     * @param disputeData
     */
    public void setDisputeData(DisputeDataFormatDate disputeData) {
        this.disputeData = disputeData;
    }

    /**
     * this Map contains all the fields of all the section of subject level data
     *
     * @return the fieldValue
     * @used To validate fields
     */
    public Map<String, Object> getFieldValue() {
        return fieldValue;
    }

    private void addAllFieldValues(Map<String, Object> data) {
        fieldValue.putAll(data);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SubjectFieldsFormatDate.class.getSimpleName() + "[", "]")
                .add("subjectLevelData=" + subjectLevelData)
                .add("nameData=" + nameData)
                .add("idData=" + Arrays.toString(idData))
                .add("telephoneData=" + Arrays.toString(telephoneData))
                .add("addressData=" + Arrays.toString(addressData))
                .add("emailData=" + Arrays.toString(emailData))
                .add("enquiryData=" + Arrays.toString(enquiryData))
                .add("EmploymentDataFormatDate=" + EmploymentDataFormatDate)
                .add("disputeData=" + disputeData)
                .add("fieldValue=" + fieldValue)
                .toString();
    }
}

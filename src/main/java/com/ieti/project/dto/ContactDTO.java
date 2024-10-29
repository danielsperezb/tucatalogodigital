package com.ieti.project.dto;

public class ContactDTO {

    private Integer contactId;
    private String contactValue;
    private String contactType;
    private Integer templateId;

    public ContactDTO() {
    }

    public ContactDTO(Integer contactId, String contactValue, String contactType, Integer templateId) {
        this.contactId = contactId;
        this.contactValue = contactValue;
        this.contactType = contactType;
        this.templateId = templateId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

}

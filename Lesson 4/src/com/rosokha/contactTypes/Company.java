package com.rosokha.contactTypes;

import com.rosokha.contactMethods.ContactMethod;

import java.time.LocalDateTime;
import java.util.List;

public class Company extends Contact {
    private String name;
    private String industry;
    private String tag;

    public Company(String displayName, String name, String industry, String tag) {
        super(displayName);
        this.name = name;
        this.industry = industry;
        this.tag = tag;
    }

    public Company(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
        super.setUpdatedAt(LocalDateTime.now());
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
        super.setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Company: " + name;
    }

}

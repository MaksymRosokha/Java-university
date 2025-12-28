package com.rosokha.contactMethods;

public abstract class ContactMethod {
    private String label;
    private boolean isPrimary;

    public ContactMethod() {
    }

    public ContactMethod(String label, boolean isPrimary) {
        this.label = label;
        this.isPrimary = isPrimary;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}

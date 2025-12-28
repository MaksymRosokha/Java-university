package com.rosokha.contactMethods;

public class Email extends ContactMethod{
    private String emailAddress;

    public Email(String emailAddress) {
        setEmailAddress(emailAddress);
    }

    public Email(String label, boolean isPrimary, String emailAddress) {
        super(label, isPrimary);
        setEmailAddress(emailAddress);
    }

    public Email(){

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        emailAddress = emailAddress.trim();
        if(!emailAddress.contains("@")){
            System.out.println("Email address must contain @");
            return;
        }
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Email: " + emailAddress + (isPrimary() ? " (primary)" : "");
    }

}

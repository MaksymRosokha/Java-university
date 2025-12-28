package com.rosokha.contactMethods;

public class Phone extends ContactMethod{
    private String phoneNumber;

    public Phone(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    public Phone(String label, boolean isPrimary, String phoneNumber) {
        super(label, isPrimary);
        setPhoneNumber(phoneNumber);
    }

    public Phone(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        phoneNumber.replace(",", "");
        phoneNumber.replace(".", "");
        phoneNumber.replace(";", "");
        if(phoneNumber.length() < 9){
            System.out.println("Phone number is too short (9+)");
            return;
        }
        for(char c : phoneNumber.toCharArray()){
            try{
                Character.getNumericValue(c);
            } catch (Exception ex){
                System.out.println("Phone number must contain only numbers");
                return;
            }
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone: " + phoneNumber + (isPrimary() ? " (primary)" : "");
    }
}

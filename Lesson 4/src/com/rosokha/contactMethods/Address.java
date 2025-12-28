package com.rosokha.contactMethods;

public class Address extends ContactMethod{
    private String country;
    private String city;
    private String street;
    private String postalCode;

    public Address(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Address(String label, boolean isPrimary, String country, String city, String street, String postalCode) {
        super(label, isPrimary);
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Address(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address: " + country + ", " + city + ", " + street + ", " + postalCode
                + (isPrimary() ? " (primary)" : "");
    }

}

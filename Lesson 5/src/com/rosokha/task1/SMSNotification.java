package com.rosokha.task1;

public class SMSNotification implements Notification {
    private String recipient;
    private String message;

    public SMSNotification() {
    }

    public SMSNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.printf("Sent sms to %s: %s\n", this.recipient, this.message);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.rosokha.task1;

public class PushNotification implements Notification {
    private String recipient;
    private String message;

    public PushNotification() {
    }

    public PushNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.printf("Sent notification to %s: %s\n", this.recipient, this.message);
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

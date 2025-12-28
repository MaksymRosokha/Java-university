package com.rosokha.contactTypes;

import com.rosokha.contactMethods.ContactMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Contact {
    private static int countContacts = 0;
    private int id;
    private String displayName;
    private final List<ContactMethod> methods;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Contact() {
        this.id = ++countContacts;
        this.methods = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Contact(String displayName) {
        this.id = ++countContacts;
        this.displayName = displayName;
        this.methods = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.setUpdatedAt(LocalDateTime.now());
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.setUpdatedAt(LocalDateTime.now());
    }

    public List<ContactMethod> getMethods() {
        return methods;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    protected void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

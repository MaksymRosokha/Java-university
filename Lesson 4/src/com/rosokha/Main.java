package com.rosokha;

import com.rosokha.contactTypes.*;
import com.rosokha.contactMethods.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        run(scan);
        scan.close();
    }

    public static void run(Scanner scan) {
        final List<Contact> contacts = new ArrayList<>();

        while (true) {
            int option = 0;
            System.out.println("- - - Your option: - - -");
            System.out.println("1 - Add contact type");
            System.out.println("2 - Add contact method");
            System.out.println("3 - Edit contact type");
            System.out.println("4 - Edit contact method");
            System.out.println("5 - Delete contact type");
            System.out.println("6 - Delete contact method");
            System.out.println("7 - Print contact type");
            System.out.println("8 - Exit");
            System.out.print("> ");

            option = readInt(scan, "The option must be a number\n");

            switch (option) {
                case 1 -> addContact(scan, contacts);
                case 2 -> addContactMethod(scan, contacts);
                case 3 -> editContact(scan, contacts);
                case 4 -> editContactMethod(scan, contacts);
                case 5 -> deleteContact(scan, contacts);
                case 6 -> deleteContactMethod(scan, contacts);
                case 7 -> printContact(contacts);
                case 8 -> {
                    System.out.println("Goodbye");
                    return;
                }
                default -> System.out.println("There is no such an option");
            }
        }
    }

    public static int readInt(Scanner scan, String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(errorMessage);
            }
        }
    }

    public static void addContact(Scanner scan, List<Contact> contacts) {
        while (true) {
            int option;
            System.out.println("What contact type do you want to add?");
            System.out.println("1 - Company");
            System.out.println("2 - Person");
            System.out.print("> ");

            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("The option must be a number\n");
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("Enter company name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter display name: ");
                    String displayName = scan.nextLine();
                    System.out.println("Enter industry: ");
                    String industry = scan.nextLine();
                    System.out.println("Enter tag: ");
                    String tag = scan.nextLine();
                    contacts.add(new Company(displayName, name, industry, tag));
                    System.out.println("The company was created successfully");
                }
                case 2 -> {
                    System.out.println("Enter person first name: ");
                    String firstName = scan.nextLine();
                    System.out.println("Enter person last name: ");
                    String lastName = scan.nextLine();
                    System.out.println("Enter display name: ");
                    String displayName = scan.nextLine();
                    System.out.println("Enter birth date: ");
                    System.out.println("Enter the year:");
                    int year = readInt(scan, "The year must be a number\n");
                    System.out.println("Enter the month: ");
                    int month = readInt(scan, "The month must be a number\n");
                    System.out.println("Enter the day: ");
                    int day = readInt(scan, "The day must be a number\n");
                    LocalDate birthDate = null;
                    try{
                        if(year >= 1900 && year <= LocalDate.now().getYear()){
                            birthDate = LocalDate.of(year, month, day);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } catch (DateTimeException | IllegalArgumentException e){
                        System.out.println("Invalid birth date");
                        continue;
                    }

                    System.out.println("Enter tag: ");
                    String tag = scan.nextLine();
                    contacts.add(new Person(displayName, firstName, lastName, birthDate, tag));
                    System.out.println("The person was created successfully");
                }
                default -> {
                    System.out.println("There is not such an option");
                    continue;
                }
            }
            break;
        }
    }

    public static void addContactMethod(Scanner scan, List<Contact> contacts){
        if (contacts.isEmpty()) {
            System.out.println("No contacts available");
            return;
        }

        System.out.println("Enter contact ID:");
        int id = readInt(scan, "ID must be a number");

        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        while (true) {
            System.out.println("Choose method type:");
            System.out.println("1 - Phone");
            System.out.println("2 - Email");
            System.out.println("3 - Address");
            System.out.print("> ");

            int option = readInt(scan, "Option must be a number");

            switch (option) {
                case 1 -> {
                    System.out.println("Enter phone number:");
                    String phone = scan.nextLine();
                    contact.getMethods().add(new Phone("private", true, phone));
                    System.out.println("Phone added");
                }
                case 2 -> {
                    System.out.println("Enter email:");
                    String email = scan.nextLine();
                    contact.getMethods().add(new Email("private", true, email));
                    System.out.println("Email added");
                }
                case 3 -> {
                    System.out.println("Country:");
                    String country = scan.nextLine();
                    System.out.println("City:");
                    String city = scan.nextLine();
                    System.out.println("Street:");
                    String street = scan.nextLine();
                    System.out.println("Postal code:");
                    String postalCode = scan.nextLine();

                    contact.getMethods().add(
                            new Address("private", true, country, city, street, postalCode)
                    );
                    System.out.println("Address added");
                }
                default -> {
                    System.out.println("Invalid option");
                    continue;
                }
            }
            break;
        }
    }

    public static void editContact(Scanner scan, List<Contact> contacts){
        System.out.println("Enter contact ID:");
        int id = readInt(scan, "ID must be a number");

        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Current display name: " + contact.getDisplayName());
        System.out.println("Enter new display name:");
        String newName = scan.nextLine();

        contact.setDisplayName(newName);
        System.out.println("Contact updated");
    }

    public static void editContactMethod(Scanner scan, List<Contact> contacts){
        System.out.println("Enter contact ID:");
        int id = readInt(scan, "ID must be a number");

        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contact == null || contact.getMethods().isEmpty()) {
            System.out.println("No methods found");
            return;
        }

        for (int i = 0; i < contact.getMethods().size(); i++) {
            System.out.println(i + " - " + contact.getMethods().get(i));
        }

        System.out.println("Choose method index:");
        int index = readInt(scan, "Index must be a number");

        if (index < 0 || index >= contact.getMethods().size()) {
            System.out.println("Invalid index");
            return;
        }

        contact.getMethods().forEach(m -> m.setPrimary(false));
        contact.getMethods().get(index).setPrimary(true);

        System.out.println("Primary method updated");
    }

    public static void deleteContact(Scanner scan, List<Contact> contacts){
        System.out.println("Enter contact ID:");
        int id = readInt(scan, "ID must be a number");

        boolean removed = contacts.removeIf(c -> c.getId() == id);

        if (removed) {
            System.out.println("Contact deleted");
        } else {
            System.out.println("Contact not found");
        }
    }

    public static void deleteContactMethod(Scanner scan, List<Contact> contacts){
        System.out.println("Enter contact ID:");
        long id = readInt(scan, "ID must be a number");

        Contact contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contact == null || contact.getMethods().isEmpty()) {
            System.out.println("No methods found");
            return;
        }

        for (int i = 0; i < contact.getMethods().size(); i++) {
            System.out.println(i + " - " + contact.getMethods().get(i));
        }

        System.out.println("Choose method index:");
        int index = readInt(scan, "Index must be a number");

        if (index < 0 || index >= contact.getMethods().size()) {
            System.out.println("Invalid index");
            return;
        }

        contact.getMethods().remove(index);
        System.out.println("Method deleted");
    }

    public static void printContact(List<Contact> contacts){
        if (contacts.isEmpty()) {
            System.out.println("No contacts");
            return;
        }

        for (Contact c : contacts) {
            System.out.println("ID: " + c.getId());

            if (c instanceof Person p) {
                System.out.println(
                        p.getFirstName() + " " + p.getLastName()
                );
            } else if (c instanceof Company co) {
                System.out.println(co.getName());
            }

            c.getMethods().forEach(m -> System.out.println(" - " + m));
            System.out.println();
        }
    }
}
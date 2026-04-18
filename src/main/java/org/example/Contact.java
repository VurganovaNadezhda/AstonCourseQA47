package org.example;

// Класс для хранения информации об одном контакте

import java.util.Objects;

public class Contact {
    private String lastName;
    private String phoneNumber;
    private String firstName;

    /**
     * Конструктор Contact
     *
     * @param lastName фамилия
     * @param firstName имя
     * @param phoneNumber номер телефона
     */
    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", lastName, firstName, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}


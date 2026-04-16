package org.example;

// Пользовательское исключение для ошибки данных в массиве

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
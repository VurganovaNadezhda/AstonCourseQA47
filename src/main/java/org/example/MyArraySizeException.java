package org.example;

// Пользовательское исключение для ошибки размера массива


public class MyArraySizeException extends Throwable {
    public MyArraySizeException(String message) {
        super(message);
        }
    }
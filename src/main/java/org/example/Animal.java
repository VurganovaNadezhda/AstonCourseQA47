package org.example;

public class Animal {
    protected String name;
    protected static int totalAnimalsCount = 0;

    // Конструктор
    public Animal(String name) {
        this.name = name;
        totalAnimalsCount++;
    }

    // Метод для бега
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    // Метод для плавания
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    // Получить общее количество животных
    public static int getTotalAnimalsCount() {
        return totalAnimalsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

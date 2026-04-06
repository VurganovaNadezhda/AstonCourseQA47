package org.example;

public interface Shape {
    // Абстрактные методы
    double getArea();      // Площадь
    double getPerimeter(); // Периметр
    String getFillColor();
    String getBorderColor();
    String getName();

    // Дефолтный метод для вывода информации
    default void displayInfo() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║ Фигура: " + String.format("%-22s", getName()) + "║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Площадь: " + String.format("%-25.2f", getArea()) + "║");
        System.out.println("║ Периметр: " + String.format("%-24.2f", getPerimeter()) + "║");
        System.out.println("║ Цвет фона: " + String.format("%-21s", getFillColor()) + "║");
        System.out.println("║ Цвет границ: " + String.format("%-20s", getBorderColor()) + "║");
        System.out.println("╚════════════════════════════════════╝");
    }
}

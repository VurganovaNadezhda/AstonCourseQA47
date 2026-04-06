package org.example;

public class Triangle implements Shape{
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    // Конструктор
    public Triangle(double sideA, double sideB, double sideC,
                    String fillColor, String borderColor) {
        // Проверяем, является ли это валидным треугольником
        if (isValidTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        } else {
            throw new IllegalArgumentException("Это не является треугольником! " +
                    "Сумма двух сторон должна быть больше третьей.");
        }
    }

    // Проверка валидности треугольника
    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b) && a > 0 && b > 0 && c > 0;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        // Используем формулу Герона
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - sideA) *
                (semiPerimeter - sideB) *
                (semiPerimeter - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getName() {
        return "Треугольник (" + sideA + "," + sideB + "," + sideC + ")";
    }

    // Геттеры и сеттеры
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}

package org.example;

public class TriangleAreaCalculator {
    public static double area(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Sides must be positive");
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        if (Double.isNaN(area)) throw new IllegalArgumentException("Invalid triangle sides");
        return area;
    }
}

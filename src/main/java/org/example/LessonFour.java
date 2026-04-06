package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LessonFour {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   РАСЧЕТ ПЛОЩАДИ И ПЕРИМЕТРА ФИГУР    ║");
        System.out.println("╚════════════════════════════════════════╝");

        // Создаем массив фигур
        Shape[] shapes = new Shape[3];

        // Создаем фигуры
        shapes[0] = new Circle(5.0, "Красный", "Черный");
        shapes[1] = new Rectangle(8.0, 6.0, "Синий", "Зеленый");
        shapes[2] = new Triangle(3.0, 4.0, 5.0, "Желтый", "Фиолетовый");

        // Выводим информацию о каждой фигуре
        System.out.println("\n");
        for (Shape shape : shapes) {
            shape.displayInfo();
        }

        // Дополнительный пример с изменением свойств
        System.out.println("\n\n╔════════════════════════════════════════╗");
        System.out.println("║      ПРИМЕРЫ С ДРУГИМИ ФИГУРАМИ       ║");
        System.out.println("╚════════════════════════════════════════╝");

        Circle circle2 = new Circle(3.5, "Оранжевый", "Белый");
        Rectangle rectangle2 = new Rectangle(10.0, 5.0, "Серый", "Темно-синий");
        Triangle triangle2 = new Triangle(5.0, 5.0, 6.0, "Светло-зеленый", "Коричневый");

        circle2.displayInfo();
        rectangle2.displayInfo();
        triangle2.displayInfo();

        // Расчет общей площади и периметра
        System.out.println("\n\n╔════════════════════════════════════════╗");
        System.out.println("║          ОБЩАЯ СТАТИСТИКА             ║");
        System.out.println("╚════════════════════════════════════════╝");

        Shape[] allShapes = {
                shapes[0], shapes[1], shapes[2],
                circle2, rectangle2, triangle2
        };

        double totalArea = 0;
        double totalPerimeter = 0;

        for (Shape shape : allShapes) {
            totalArea += shape.getArea();
            totalPerimeter += shape.getPerimeter();
        }

        System.out.println("\nВсего фигур: " + allShapes.length);
        System.out.printf("Общая площадь: %.2f\n", totalArea);
        System.out.printf("Общий периметр: %.2f\n", totalPerimeter);

        // Поиск фигуры с максимальной площадью
        Shape maxAreaShape = allShapes[0];
        for (Shape shape : allShapes) {
            if (shape.getArea() > maxAreaShape.getArea()) {
                maxAreaShape = shape;
            }
        }

        System.out.println("\nФигура с максимальной площадью:");
        System.out.printf("  %s: %.2f\n", maxAreaShape.getName(), maxAreaShape.getArea());

        // Поиск фигуры с максимальным периметром
        Shape maxPerimeterShape = allShapes[0];
        for (Shape shape : allShapes) {
            if (shape.getPerimeter() > maxPerimeterShape.getPerimeter()) {
                maxPerimeterShape = shape;
            }
        }

        System.out.println("Фигура с максимальным периметром:");
        System.out.printf("  %s: %.2f\n", maxPerimeterShape.getName(), maxPerimeterShape.getPerimeter());
    }
}
package org.example;

public class ProductStore {
    public static void main(String[] args) {
        // Объявляем массив объектов типа Product
        Product[] productsArray = new Product[5];

        // Заполняем массив товарами
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro Max", "15.09.2024",
                "Apple Inc.", "USA", 4999, false);

        productsArray[2] = new Product("Sony WH-1000XM5", "10.08.2024",
                "Sony Corporation", "Japan", 1299, true);

        productsArray[3] = new Product("MacBook Pro 16", "03.01.2025",
                "Apple Inc.", "USA", 8999, false);

        productsArray[4] = new Product("Dell XPS 13", "20.12.2024",
                "Dell Technologies", "USA", 3499, true);

        // Выводим информацию о всех товарах
        System.out.println("\n========== КАТАЛОГ ТОВАРОВ ==========\n");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар #" + (i + 1));
            productsArray[i].displayInfo();
        }

        // Пример: выводим информацию о конкретном товаре
        System.out.println("\nИнформация о первом товаре:");
        productsArray[0].displayInfo();

        // Пример: изменяем статус бронирования
        System.out.println("Изменяем статус бронирования для товара #2:");
        productsArray[1].setBooked(true);
        productsArray[1].displayInfo();
    }
}

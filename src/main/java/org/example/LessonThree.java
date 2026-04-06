package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LessonThree {
    public static void main(String[] args) {
        System.out.println("========== ТЕСТИРОВАНИЕ ЖИВОТНЫХ ==========\n");

        // Создаем животных
        Dog bobik = new Dog("Бобик");
        Dog sharik = new Dog("Шарик");
        Cat musya = new Cat("Мусяшка");
        Cat barsik = new Cat("Барсик");
        Cat whiskers = new Cat("Усик");

        // Тестируем методы бега и плавания
        System.out.println("--- Тестирование бега ---");
        bobik.run(150);
        bobik.run(600);  // Не может
        musya.run(100);
        musya.run(250);  // Не может

        System.out.println("\n--- Тестирование плавания ---");
        sharik.swim(8);
        sharik.swim(15);  // Не может
        barsik.swim(5);   // Кот не умеет плавать

        // Выводим счетчики
        System.out.println("\n--- Статистика животных ---");
        System.out.println("Создано собак: " + Dog.getDogsCount());
        System.out.println("Создано котов: " + Cat.getCatsCount());
        System.out.println("Всего животных: " + Animal.getTotalAnimalsCount());

        // ====== ТЕСТИРОВАНИЕ КОРМЛЕНИЯ ======
        System.out.println("\n\n========== ТЕСТИРОВАНИЕ КОРМЛЕНИЯ КОТОВ ==========\n");

        // Создаем массив котов
        Cat[] cats = {musya, barsik, whiskers};

        // Создаем миску с едой
        Bowl bowl = new Bowl(25);

        System.out.println("Начальное состояние:");
        bowl.displayBowlInfo();
        System.out.println();

        // Попытаемся накормить всех котов
        System.out.println("--- Котов просят покушать ---");
        cats[0].eat(bowl, 10);  // Мусяшка ест 10
        cats[1].eat(bowl, 8);   // Барсик ест 8 (осталось 7)
        cats[2].eat(bowl, 15);  // Усик пытается съесть 15, но в миске только 7

        System.out.println("\n--- Состояние миски после кормления ---");
        bowl.displayBowlInfo();

        // Выводим информацию о сытости каждого кота
        System.out.println("\n--- Информация о сытости котов ---");
        for (Cat cat : cats) {
            System.out.println(cat.getSatietyInfo());
        }

        // Добавляем еду в миску
        System.out.println("\n--- Добавляем еду в миску ---");
        bowl.addFood(20);

        // Пытаемся накормить голодного кота
        System.out.println("\n--- Второй попыток накормить голодного кота ---");
        whiskers.setSatiety(false);  // Делаем кота снова голодным
        whiskers.eat(bowl, 15);

        // Финальное состояние
        System.out.println("\n--- Финальное состояние ---");
        bowl.displayBowlInfo();
        System.out.println("Информация о сытости котов:");
        for (Cat cat : cats) {
            System.out.println("  " + cat.getSatietyInfo());
        }
    }
}
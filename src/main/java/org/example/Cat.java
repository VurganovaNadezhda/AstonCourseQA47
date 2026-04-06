package org.example;

public class Cat extends Animal{
    private static final int MAX_RUN_DISTANCE = 200;  // Максимальное расстояние бега
    private static int catsCount = 0;                  // Счетчик котов
    private boolean satiety;                           // Сытость кота (false = голоден, true = сыт)

    // Конструктор
    public Cat(String name) {
        super(name);
        this.satiety = false;  // При создании кот голоден
        catsCount++;
    }

    // Переопределяем метод бега
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум " + MAX_RUN_DISTANCE + " м.)");
        }
    }

    // Переопределяем метод плавания (коты не умеют плавать)
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    // Метод для кормления из миски
    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.takeFoodFromBowl(foodAmount)) {
            this.satiety = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " хотел поесть, но в миске недостаточно еды.");
        }
    }

    // Получить количество созданных котов
    public static int getCatsCount() {
        return catsCount;
    }

    // Получить статус сытости
    public boolean isSatiety() {
        return satiety;
    }

    // Установить статус сытости
    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    // Получить информацию о сытости
    public String getSatietyInfo() {
        return name + " - " + (satiety ? "Сыт" : "Голоден");
    }

}

package org.example;

public class Dog extends Animal{
    private static final int MAX_RUN_DISTANCE = 500;  // Максимальное расстояние бега
    private static final int MAX_SWIM_DISTANCE = 10;   // Максимальное расстояние плавания
    private static int dogsCount = 0;                   // Счетчик собак

    // Конструктор
    public Dog(String name) {
        super(name);
        dogsCount++;
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

    // Переопределяем метод плавания
    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум " + MAX_SWIM_DISTANCE + " м.)");
        }
    }

    // Получить количество созданных собак
    public static int getDogsCount() {
        return dogsCount;
    }

}

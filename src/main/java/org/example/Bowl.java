package org.example;

public class Bowl {
    private int foodAmount;  // Количество еды в миске

    // Конструктор
    public Bowl(int initialFood) {
        this.foodAmount = Math.max(0, initialFood);  // Не может быть отрицательной
    }

    // Метод для попытки взять еду из миски
    public boolean takeFoodFromBowl(int amountNeeded) {
        if (amountNeeded <= foodAmount) {
            foodAmount -= amountNeeded;
            return true;
        }
        return false;
    }

    // Метод для добавления еды в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавили " + amount + " еды. Всего в миске: " + foodAmount);
        } else {
            System.out.println("Ошибка: нельзя добавить отрицательное количество еды.");
        }
    }

    // Получить текущее количество еды
    public int getFoodAmount() {
        return foodAmount;
    }

    // Вывести информацию о миске
    public void displayBowlInfo() {
        System.out.println("В миске: " + foodAmount + " еды");
    }
}

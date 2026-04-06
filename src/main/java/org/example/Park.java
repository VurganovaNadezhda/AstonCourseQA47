package org.example;

public class Park {
    private String parkName;
    private Attraction[] attractions;

    // Конструктор
    public Park(String parkName, int attractionCount) {
        this.parkName = parkName;
        this.attractions = new Attraction[attractionCount];
    }

    // Внутренний класс для хранения информации об аттракционах
    public class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        // Конструктор внутреннего класса
        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        // Метод для вывода информации об аттракционе
        public void displayAttractionInfo() {
            System.out.println("  ├─ Название: " + name);
            System.out.println("  ├─ Время работы: " + workingHours);
            System.out.println("  └─ Стоимость билета: " + cost + " руб.");
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }

    // Метод для добавления аттракциона в парк
    public void addAttraction(int index, String name, String workingHours, double cost) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, workingHours, cost);
        } else {
            System.out.println("Ошибка: индекс вне диапазона");
        }
    }

    // Метод для вывода информации о парке и всех аттракционах
    public void displayParkInfo() {
        System.out.println("\n═══════════════════════════════════");
        System.out.println("Парк: " + parkName);
        System.out.println("═══════════════════════════════════");
        System.out.println("Аттракционы:");
        for (int i = 0; i < attractions.length; i++) {
            if (attractions[i] != null) {
                System.out.println((i + 1) + ".");
                attractions[i].displayAttractionInfo();
            }
        }
        System.out.println("═══════════════════════════════════\n");
    }

    // Метод для подсчета средней стоимости билетов
    public double getAveragePrice() {
        double totalCost = 0;
        int count = 0;
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                totalCost += attraction.cost;
                count++;
            }
        }
        return count > 0 ? totalCost / count : 0;
    }

    // Геттеры и сеттеры
    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public static void main(String[] args) {
        // Создаем парк с 4 аттракционами
        Park myPark = new Park("Волшебная страна", 4);

        // Добавляем аттракционы
        myPark.addAttraction(0, "Колесо обозрения", "09:00 - 23:00", 350);
        myPark.addAttraction(1, "Американские горки", "10:00 - 22:00", 500);
        myPark.addAttraction(2, "Карусель", "09:00 - 21:00", 200);
        myPark.addAttraction(3, "Дом страха", "11:00 - 23:00", 400);

        // Выводим информацию о парке
        myPark.displayParkInfo();

        // Выводим среднюю стоимость билетов
        System.out.println("Средняя стоимость билета: " + myPark.getAveragePrice() + " руб.\n");
    }
}

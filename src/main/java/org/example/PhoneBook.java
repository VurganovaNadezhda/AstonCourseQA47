package org.example;

// Класс Телефонный Справочник . Хранит список фамилий и телефонных номеров

import java.util.*;

public class PhoneBook {
    // Используем Map<фамилия, List<номер телефона>>
    // для поддержки однофамильцев
    private Map<String, List<Contact>> contacts;

    /**
     * Конструктор
     */
    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    /**
     * Добавляет новую запись в справочник
     *
     * @param lastName фамилия контакта
     * @param firstName имя контакта
     * @param phoneNumber номер телефона
     */
    public void add(String lastName, String firstName, String phoneNumber) {
        // Валидация входных данных
        if (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("✗ Ошибка: фамилия не может быть пустой");
            return;
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.out.println("✗ Ошибка: номер телефона не может быть пустым");
            return;
        }

        // Нормализуем данные (убираем лишние пробелы и приводим к нужному формату)
        lastName = lastName.trim();
        firstName = firstName != null ? firstName.trim() : "N/A";
        phoneNumber = phoneNumber.trim();

        // Проверяем, есть ли уже такой номер
        if (isPhoneNumberExists(phoneNumber)) {
            System.out.printf("✗ Ошибка: номер %s уже существует в справочнике%n", phoneNumber);
            return;
        }

        // Создаем новый контакт
        Contact contact = new Contact(lastName, firstName, phoneNumber);

        // Если фамилия уже есть, добавляем в существующий список
        if (contacts.containsKey(lastName)) {
            contacts.get(lastName).add(contact);
            System.out.printf("✓ Добавлен контакт: %s%n", contact);
        } else {
            // Создаем новый список для этой фамилии
            List<Contact> contactList = new ArrayList<>();
            contactList.add(contact);
            contacts.put(lastName, contactList);
            System.out.printf("✓ Добавлен контакт: %s%n", contact);
        }
    }

    /**
     * Альтернативный метод add для добавления контакта только с фамилией и номером
     *
     * @param lastName фамилия контакта
     * @param phoneNumber номер телефона
     */
    public void add(String lastName, String phoneNumber) {
        add(lastName, "", phoneNumber);
    }

    /**
     * Ищет номер телефона по фамилии
     * Если есть несколько телефонов под одной фамилией, выводит все
     *
     * @param lastName фамилия для поиска
     * @return список контактов с данной фамилией
     */
    public List<Contact> get(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            System.out.println("✗ Ошибка: фамилия не может быть пустой");
            return new ArrayList<>();
        }

        lastName = lastName.trim();

        if (contacts.containsKey(lastName)) {
            return new ArrayList<>(contacts.get(lastName));
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Ищет контакт по номеру телефона
     *
     * @param phoneNumber номер телефона
     * @return контакт если найден, null иначе
     */
    public Contact findByPhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return null;
        }

        phoneNumber = phoneNumber.trim();

        for (List<Contact> contactList : contacts.values()) {
            for (Contact contact : contactList) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    return contact;
                }
            }
        }
        return null;
    }

    /**
     * Проверяет, существует ли такой номер телефона
     *
     * @param phoneNumber номер телефона
     * @return true если существует, false иначе
     */
    private boolean isPhoneNumberExists(String phoneNumber) {
        return findByPhone(phoneNumber) != null;
    }

    /**
     * Удаляет контакт по фамилии и номеру телефона
     *
     * @param lastName фамилия
     * @param phoneNumber номер телефона
     * @return true если контакт удален, false иначе
     */
    public boolean remove(String lastName, String phoneNumber) {
        if (!contacts.containsKey(lastName)) {
            System.out.printf("✗ Фамилия '%s' не найдена в справочнике%n", lastName);
            return false;
        }

        List<Contact> contactList = contacts.get(lastName);
        boolean removed = contactList.removeIf(contact ->
                contact.getPhoneNumber().equals(phoneNumber));

        if (removed) {
            System.out.printf("✓ Контакт удален: %s %s%n", lastName, phoneNumber);

            // Если список пуст, удаляем фамилию из справочника
            if (contactList.isEmpty()) {
                contacts.remove(lastName);
            }
        } else {
            System.out.printf("✗ Контакт не найден: %s %s%n", lastName, phoneNumber);
        }

        return removed;
    }

    /**
     * Удаляет все контакты с данной фамилией
     *
     * @param lastName фамилия
     * @return количество удаленных контактов
     */
    public int removeAll(String lastName) {
        if (!contacts.containsKey(lastName)) {
            System.out.printf("✗ Фамилия '%s' не найдена в справочнике%n", lastName);
            return 0;
        }

        int count = contacts.get(lastName).size();
        contacts.remove(lastName);
        System.out.printf("✓ Удалено %d контактов с фамилией '%s'%n", count, lastName);
        return count;
    }

    /**
     * Выводит все контакты с указанной фамилией
     *
     * @param lastName фамилия для поиска
     */
    public void printByLastName(String lastName) {
        List<Contact> found = get(lastName);

        if (found.isEmpty()) {
            System.out.printf("✗ Контакты с фамилией '%s' не найдены%n", lastName);
        } else {
            System.out.printf("\n=== Контакты с фамилией '%s' ===%n", lastName);
            for (int i = 0; i < found.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, found.get(i));
            }
        }
    }

    /**
     * Выводит все контакты в справочнике, отсортированные по фамилии
     */
    public void printAll() {
        if (contacts.isEmpty()) {
            System.out.println("✗ Справочник пуст");
            return;
        }

        System.out.println("\n=== Все контакты в справочнике ===");

        // Сортируем фамилии по алфавиту
        List<String> sortedLastNames = new ArrayList<>(contacts.keySet());
        Collections.sort(sortedLastNames);

        int index = 1;
        for (String lastName : sortedLastNames) {
            List<Contact> contactList = contacts.get(lastName);
            for (Contact contact : contactList) {
                System.out.printf("%d. %s%n", index++, contact);
            }
        }
    }

    /**
     * Выводит статистику справочника
     */
    public void printStatistics() {
        System.out.println("\n=== Статистика справочника ===");
        System.out.printf("Уникальных фамилий: %d%n", contacts.size());

        int totalContacts = 0;
        for (List<Contact> contactList : contacts.values()) {
            totalContacts += contactList.size();
        }
        System.out.printf("Всего контактов: %d%n", totalContacts);

        // Находим фамилию с максимальным количеством однофамильцев
        String maxLastName = "";
        int maxCount = 0;
        for (Map.Entry<String, List<Contact>> entry : contacts.entrySet()) {
            if (entry.getValue().size() > maxCount) {
                maxCount = entry.getValue().size();
                maxLastName = entry.getKey();
            }
        }

        if (maxCount > 1) {
            System.out.printf("Фамилия с максимальным количеством однофамильцев: '%s' (%d)%n",
                    maxLastName, maxCount);
        }
    }

    /**
     * Получает количество контактов в справочнике
     *
     * @return количество контактов
     */
    public int size() {
        int count = 0;
        for (List<Contact> contactList : contacts.values()) {
            count += contactList.size();
        }
        return count;
    }

    /**
     * Очищает справочник
     */
    public void clear() {
        contacts.clear();
        System.out.println("✓ Справочник очищен");
    }

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║         Телефонный Справочник v1.0                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Создание справочника
        PhoneBook phoneBook = new PhoneBook();

        // ===== ТЕСТ 1: Добавление контактов =====
        System.out.println("\n--- ТЕСТ 1: Добавление контактов ---");
        phoneBook.add("Иванов", "Иван", "89991234567");
        phoneBook.add("Иванов", "Петр", "89991234568");
        phoneBook.add("Иванов", "Сергей", "89991234569");
        phoneBook.add("Сидоров", "Алексей", "89991234570");
        phoneBook.add("Петров", "Владимир", "89991234571");
        phoneBook.add("Петров", "Константин", "89991234572");
        phoneBook.add("Смирнов", "Николай", "89991234573");

        // ===== ТЕСТ 2: Вывод всех контактов =====
        System.out.println("\n--- ТЕСТ 2: Вывод всех контактов ---");
        phoneBook.printAll();

        // ===== ТЕСТ 3: Поиск по фамилии (однофамильцы) =====
        System.out.println("\n--- ТЕСТ 3: Поиск однофамильцев ---");
        phoneBook.printByLastName("Иванов");
        phoneBook.printByLastName("Петров");
        phoneBook.printByLastName("Сидоров");

        // ===== ТЕСТ 4: Поиск несуществующей фамилии =====
        System.out.println("\n--- ТЕСТ 4: Поиск несуществующей фамилии ---");
        phoneBook.printByLastName("Козлов");

        // ===== ТЕСТ 5: Поиск по номеру телефона =====
        System.out.println("\n--- ТЕСТ 5: Поиск по номеру телефона ---");
        Contact found = phoneBook.findByPhone("89991234570");
        if (found != null) {
            System.out.printf("✓ Найден контакт: %s%n", found);
        }

        // ===== ТЕСТ 6: Добавление дубликата номера =====
        System.out.println("\n--- ТЕСТ 6: Попытка добавления дубликата номера ---");
        phoneBook.add("Новиков", "Федор", "89991234567");

        // ===== ТЕСТ 7: Удаление конкретного контакта =====
        System.out.println("\n--- ТЕСТ 7: Удаление конкретного контакта ---");
        phoneBook.remove("Иванов", "89991234568");
        phoneBook.printByLastName("Иванов");

        // ===== ТЕСТ 8: Удаление всех контактов с фамилией =====
        System.out.println("\n--- ТЕСТ 8: Удаление всех контактов с фамилией ---");
        phoneBook.removeAll("Петров");

        // ===== ТЕСТ 9: Статистика =====
        System.out.println("\n--- ТЕСТ 9: Статистика справочника ---");
        phoneBook.printStatistics();
        System.out.printf("Всего контактов: %d%n", phoneBook.size());

        // ===== ТЕСТ 10: Финальный список =====
        System.out.println("\n--- ТЕСТ 10: Финальный список контактов ---");
        phoneBook.printAll();

        // ===== ТЕСТ 11: Использование метода get() =====
        System.out.println("\n--- ТЕСТ 11: Использование метода get() ---");
        List<Contact> ivanovContacts = phoneBook.get("Иванов");
        System.out.printf("Найдено %d контактов с фамилией 'Иванов':%n", ivanovContacts.size());
        for (Contact contact : ivanovContacts) {
            System.out.printf("  • %s%n", contact);
        }

        // ===== ТЕСТ 12: Добавление контактов с пробелами =====
        System.out.println("\n--- ТЕСТ 12: Добавление контактов с лишними пробелами ---");
        phoneBook.add("  Волков  ", "  Дмитрий  ", "  89991234574  ");
        phoneBook.printByLastName("Волков");
    }
}

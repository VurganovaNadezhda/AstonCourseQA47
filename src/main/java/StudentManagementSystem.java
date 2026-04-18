import java.util.*;

// Класс для управления студентами
public class StudentManagementSystem {
     // Удаляет студентов со средним баллом < 3
    //@param students коллекция студентов

    public static void removeStudentsWithLowGPA(Set<Student> students) {
        System.out.println("\n>>> Удаление студентов со средним баллом < 3...");

        // Используем iterator для безопасного удаления во время итерации
        Iterator<Student> iterator = students.iterator();
        List<Student> removed = new ArrayList<>();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                removed.add(student);
                iterator.remove();
                System.out.printf("✓ Удален: %s (средний балл: %.2f)%n",
                        student.getName(), student.getAverageGrade());
            }
        }

        if (removed.isEmpty()) {
            System.out.println("✓ Студентов с баллом < 3 не найдено");
        }
    }

    /**
     * Переводит студента на следующий курс, если средний балл >= 3
     *
     * @param student студент для перевода
     * @return true если перевод успешен, false в противном случае
     */
    public static boolean promoteStudent(Student student) {
        double average = student.getAverageGrade();
        if (student.promoteToNextCourse()) {
            System.out.printf("✓ %s переведен на %d курс (средний балл: %.2f)%n",
                    student.getName(), student.getCourse(), average);
            return true;
        } else {
            System.out.printf("✗ %s не переведен (средний балл: %.2f < 3.0)%n",
                    student.getName(), average);
            return false;
        }
    }

    /**
     * Переводит всех студентов с баллом >= 3 на следующий курс
     *
     * @param students коллекция студентов
     */
    public static void promoteAllEligibleStudents(Set<Student> students) {
        System.out.println("\n>>> Перевод студентов на следующий курс...");

        for (Student student : students) {
            promoteStudent(student);
        }
    }

    /**
     * Выводит на консоль имена студентов, обучающихся на заданном курсе
     *
     * @param students коллекция студентов
     * @param course номер курса
     */
    public static void printStudents(Set<Student> students, int course) {
        System.out.printf("\n>>> Студенты %d курса:%n", course);

        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.printf("  • %s (группа: %s, средний балл: %.2f)%n",
                        student.getName(), student.getGroup(), student.getAverageGrade());
                found = true;
            }
        }

        if (!found) {
            System.out.printf("  Студентов на %d курсе не найдено%n", course);
        }
    }

    /**
     * Выводит информацию о всех студентах
     *
     * @param students коллекция студентов
     */
    public static void printAllStudents(Set<Student> students) {
        System.out.println("\n=== Список всех студентов ===");
        for (Student student : students) {
            System.out.println("  " + student);
        }
    }

    /**
     * Выводит статистику по студентам
     *
     * @param students коллекция студентов
     */
    public static void printStatistics(Set<Student> students) {
        System.out.println("\n=== Статистика ===");
        System.out.printf("Всего студентов: %d%n", students.size());

        Map<Integer, Integer> courseCount = new HashMap<>();
        double totalAverage = 0;
        int count = 0;

        for (Student student : students) {
            int course = student.getCourse();
            courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
            totalAverage += student.getAverageGrade();
            count++;
        }

        if (count > 0) {
            System.out.printf("Средний балл всех студентов: %.2f%n", totalAverage / count);
        }

        System.out.println("\nРаспределение по курсам:");
        courseCount.keySet().stream().sorted().forEach(course ->
                System.out.printf("  Курс %d: %d студентов%n", course, courseCount.get(course))
        );
    }

    public static void main(String[] args) {
        // Создание коллекции студентов (Set автоматически избегает дубликатов)
        Set<Student> students = new HashSet<>();

        // Добавление студентов
        students.add(new Student("Иван Петров", "АИ-2301", 1,
                Arrays.asList(4, 5, 4, 3, 5)));
        students.add(new Student("Мария Сидорова", "АИ-2301", 1,
                Arrays.asList(2, 2, 3, 2, 1)));
        students.add(new Student("Петр Иванов", "АИ-2302", 1,
                Arrays.asList(5, 5, 5, 4, 5)));
        students.add(new Student("Анна Козлова", "АИ-2302", 2,
                Arrays.asList(3, 4, 3, 4, 3)));
        students.add(new Student("Сергей Смирнов", "АИ-2303", 1,
                Arrays.asList(2, 2, 2, 2, 2)));
        students.add(new Student("Елена Волкова", "АИ-2303", 2,
                Arrays.asList(4, 3, 4, 3, 4)));
        students.add(new Student("Владимир Соколов", "АИ-2304", 2,
                Arrays.asList(3, 3, 3, 3, 3)));
        students.add(new Student("Ольга Морозова", "АИ-2304", 3,
                Arrays.asList(5, 4, 5, 4, 5)));

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║      Система управления студентами                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // 1. Вывод всех студентов
        printAllStudents(students);

        // 2. Вывод статистики до изменений
        printStatistics(students);

        // 3. Удаление студентов со средним баллом < 3
        removeStudentsWithLowGPA(students);

        // 4. Вывод студентов после удаления
        printAllStudents(students);

        // 5. Перевод студентов на следующий курс
        promoteAllEligibleStudents(students);

        // 6. Вывод студентов после перевода
        printAllStudents(students);

        // 7. Вывод студентов по курсам
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);

        // 8. Финальная статистика
        printStatistics(students);
    }
}


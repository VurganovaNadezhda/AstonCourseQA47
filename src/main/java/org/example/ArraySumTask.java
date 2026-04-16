package org.example;

// Класс для работы с двумерным массивом

public class ArraySumTask {

    /**
     * Метод для суммирования элементов двумерного массива размером 4х4
     *
     * @param array двумерный строковый массив
     * @return сумма всех элементов массива (преобразованных в int)
     * @throws MyArraySizeException если размер массива не 4х4
     * @throws MyArrayDataException если не удалось преобразовать элемент в int
     */
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array == null || array.length != 4) {
            throw new MyArraySizeException("Ошибка: массив должен быть размером 4х4. " +
                    "Текущее количество строк: " + (array == null ? "null" : array.length));
        }

        // Проверка количества столбцов
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException("Ошибка: каждая строка должна содержать 4 элемента. " +
                        "Строка " + i + " содержит: " + (array[i] == null ? "null" : array[i].length) + " элементов");
            }
        }

        int sum = 0;

        // Проход по всем элементам массива
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    // Попытка преобразовать элемент в int
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    // Выброс исключения с указанием позиции
                    throw new MyArrayDataException(
                            String.format("Ошибка преобразования данных в ячейке [%d][%d]. " +
                                            "Значение '%s' не может быть преобразовано в целое число",
                                    i, j, array[i][j])
                    );
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Обработка выхода за границы массива
                    throw new MyArrayDataException(
                            String.format("Ошибка доступа к ячейке [%d][%d]: выход за границы массива", i, j)
                    );
                }
            }
        }

        return sum;
    }

    /**
     * Метод для демонстрации ArrayIndexOutOfBoundsException
     */
    public static void demonstrateArrayIndexException() {
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");
        String[][] testArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Попытка доступа к элементу [4][0] (выход за границы)...");
            String value = testArray[4][0]; // Индекс 4 выходит за границы (есть только 0-3)
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Поймано исключение ArrayIndexOutOfBoundsException!");
            System.out.println("  Сообщение: " + e.getMessage());
        }

        try {
            System.out.println("\nПопытка доступа к элементу [0][5] (выход за границы по столбцам)...");
            String value = testArray[0][5]; // Индекс 5 выходит за границы (есть только 0-3)
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Поймано исключение ArrayIndexOutOfBoundsException!");
            System.out.println("  Сообщение: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Тест 1: Корректный массив 4х4 ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(correctArray);
            System.out.println("✓ Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("✗ Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✗ Ошибка данных: " + e.getMessage());
        }

        // Тест 2: Массив неправильного размера (3х3)
        System.out.println("\n=== Тест 2: Массив неправильного размера (3х3) ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = sumArray(wrongSizeArray);
            System.out.println("✓ Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("✓ Поймано исключение MyArraySizeException!");
            System.out.println("  Сообщение: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✗ Ошибка данных: " + e.getMessage());
        }

        // Тест 3: Массив с неверными данными (текст вместо числа)
        System.out.println("\n=== Тест 3: Массив с неверными данными ===");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(invalidDataArray);
            System.out.println("✓ Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("✗ Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✓ Поймано исключение MyArrayDataException!");
            System.out.println("  Сообщение: " + e.getMessage());
        }

        // Тест 4: Массив с null
        System.out.println("\n=== Тест 4: Массив с null ===");
        try {
            int result = sumArray(null);
            System.out.println("✓ Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("✓ Поймано исключение MyArraySizeException!");
            System.out.println("  Сообщение: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✗ Ошибка данных: " + e.getMessage());
        }

        // Тест 5: Массив с отрицательными числами
        System.out.println("\n=== Тест 5: Массив с отрицательными числами ===");
        String[][] negativeArray = {
                {"-1", "-2", "-3", "-4"},
                {"-5", "-6", "-7", "-8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(negativeArray);
            System.out.println("✓ Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("✗ Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("✗ Ошибка данных: " + e.getMessage());
        }

        // Демонстрация ArrayIndexOutOfBoundsException
        demonstrateArrayIndexException();
    }
}

